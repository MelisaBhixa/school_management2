/**
 StudentServiceTest.java
 Entity for StudentServiceTest
 Author: Zuko Fukula (217299911)
 Date: 13 June 2022
 */


package za.ac.cput.service.users.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.userInfo.Name;
import za.ac.cput.domain.users.Student;
import za.ac.cput.factory.userInfo.NameFactory;
import za.ac.cput.factory.users.StudentFactory;
import za.ac.cput.service.users.IStudentService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class StudentServiceTest {
    private final Name name = NameFactory.newName("Zuko", "Joe", "Fukula");
    private final Student student = StudentFactory.newStudent("217299911","217299911@mycput.ac.za", name);

    @Autowired
    private IStudentService service;

    @Order(1)
    @Test
    void save() {
        Student saved = this.service.save(this.student);
        assertAll(
                ()->assertNotNull(saved),
                ()->assertEquals(this.student,saved)
        );
    }

    @Order(2)
    @Test
    void read() {
        Optional<Student> read = this.service.read(this.student.getStudentId());
        System.out.println(read);
        assertAll(
                ()-> assertTrue(read.isPresent()),
                ()->assertEquals(this.student,read.get())
        );
    }

    @Order(3)
    @Test
    void findAll() {
        List<Student> studentList = this.service.findAll();
        assertEquals(1,studentList.size());
    }

    @Test
    @Order(4)
    void findByEmail() {
        String email = this.student.getEmail();
        Optional <Student> read = this.service.findByEmail(student.getEmail());
        System.out.println(read);
        assertAll(
                ()-> assertTrue(read.isPresent()),
                ()->assertEquals(this.student,read.get())
        );
    }

}
