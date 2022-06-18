/**
 StudentFactoryTest.java
 Factory test for Student
 Author: Zuko Fukula (217299911)
 Date: 16 June 2022
 */

package za.ac.cput.factory.users;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.userInfo.Name;
import za.ac.cput.domain.users.Student;
import za.ac.cput.factory.userInfo.NameFactory;
import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {

    Name name = NameFactory.newName("Zuko", "Joe", " Fukula");

    @Test
    public void invalidTest(){
        Student student = StudentFactory.newStudent("217299911", "217299911@mycput.ac.za", name);
        assertNull(student.getStudentId());
        System.out.println(student);
    }

    @Test

    public void equalityValidTest(){
        Student student = StudentFactory.newStudent("217299911", "217299911@mycput.ac.za", name);
        System.out.println("Email: "+ student.getEmail());
        assertEquals("217299911@mycput.ac.za", student.getEmail());
    }

    @Test
    public void validTest(){
        Student student = StudentFactory.newStudent("", "217299911@mycput.ac.za", name);
        assertNull(student.getStudentId());
        System.out.println(student);
    }

    @Disabled("Test Disabled")
    @Test

    public void disableTest(){
        Student student = StudentFactory.newStudent("217299911", "217299911@mycput.ac.za", name);
        assertSame("217299911", student.getStudentId());
    }
}
