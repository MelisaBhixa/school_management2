/**
 StudentControllerTest.java
 Controller Test for Student
 Author: Zuko Fukula (217299911)
 Date: 16 June 2022
 */



package za.ac.cput.controller.users;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.userInfo.Name;
import za.ac.cput.domain.users.Student;
import za.ac.cput.factory.userInfo.NameFactory;
import za.ac.cput.factory.users.StudentFactory;
import za.ac.cput.service.users.impl.StudentService;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private StudentController controller;
    @Autowired private TestRestTemplate restTemplate;

    private StudentService service;
    private Name name;
    private Student student;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.name = NameFactory.newName("Zuko", "Joe", "Fukula");
        this.student = StudentFactory.newStudent("217299911", "217299911@mycput.ac.za", name);
        this.baseUrl = "http://localhost:" + this.port + "/school-management/student/";
    }

    @Test
    @Order(1)
    void save() {
        String url = baseUrl + "save";
        ResponseEntity<Student> response = this.restTemplate.postForEntity(url, this.student, Student.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(2)
    void read() {
        String url = baseUrl + "read/" + this.student.getStudentId();
        System.out.println(url);
        ResponseEntity<Student> response = this.restTemplate.getForEntity(url, Student.class);
        System.out.println(response.toString());
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(4)
    void delete() {
        String url = baseUrl + "delete/"+ this.student.getStudentId();
        this.restTemplate.delete(url);
    }

    @Test
    @Order(3)
    void findAll() {
        String url = baseUrl + "all";
        ResponseEntity<Student[]> response =
                this.restTemplate.getForEntity(url, Student[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(1, response.getBody().length)
        );
    }

    @Test
    @Order(5)
    void findByEmail() {
        String url = baseUrl + "read-by-email/" + this.student.getEmail();
        System.out.println(url);
        ResponseEntity<Student> response =
                this.restTemplate.getForEntity(url, Student.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode())
        );
    }
}
