package za.ac.cput.controller.users;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.userInfo.Name;
import za.ac.cput.domain.users.Employee;
import za.ac.cput.factory.userInfo.NameFactory;
import za.ac.cput.factory.users.EmployeeFactory;
import za.ac.cput.service.users.impl.EmployeeService;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private EmployeeController controller;
    @Autowired private TestRestTemplate restTemplate;

    private EmployeeService service;
    private Name name;
    private Employee employee;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.name = NameFactory.newName("Legiste", "MiddleName", "lastName");
        this.employee = EmployeeFactory.newEmployee("emp_Id", "email@email.com", name);
        this.baseUrl = "http://localhost:" + this.port + "/school-management/employee/";
    }

    @Test
    @Order(1)
    void save() {
        String url = baseUrl + "save";
        ResponseEntity<Employee> response = this.restTemplate.postForEntity(url, this.employee, Employee.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(2)
    void read() {
        String url = baseUrl + "read/" + this.employee.getStaffId();
        System.out.println(url);
        ResponseEntity<Employee> response = this.restTemplate.getForEntity(url, Employee.class);
        System.out.println(response.toString());
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(4)
    void delete() {
        String url = baseUrl + "delete/"+ this.employee.getStaffId();
        this.restTemplate.delete(url);
    }

    @Test
    @Order(3)
    void findAll() {
        String url = baseUrl + "all";
        ResponseEntity<Employee[]> response =
                this.restTemplate.getForEntity(url, Employee[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(1, response.getBody().length)
        );
    }

    @Test
    @Order(5)
    void findByEmail() {
        String url = baseUrl + "read-by-email/" + this.employee.getEmail();
        System.out.println(url);
        ResponseEntity<Employee> response =
                this.restTemplate.getForEntity(url, Employee.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode())
        );
    }
}