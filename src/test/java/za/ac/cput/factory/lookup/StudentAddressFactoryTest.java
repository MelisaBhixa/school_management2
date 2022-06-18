/**
 StudentAddressFactoryTest.java
 Factory test for StudentAddresss
 Author: Zuko Fukula (217299911)
 Date: 16 June 2022
 */

package za.ac.cput.factory.lookup;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.location.Address;
import za.ac.cput.domain.lookup.StudentAddress;
import static org.junit.jupiter.api.Assertions.*;

class StudentAddressFactoryTest {

    @Test
    public void invalidTest(){
        StudentAddress studentAddress = StudentAddressFactory.newStudentAddress("217299911", new Address());
        assertNull(studentAddress.getStudentId());
        System.out.println(studentAddress);
    }

    @Test

    public void equalityValidTest(){
        StudentAddress studentAddress = StudentAddressFactory.newStudentAddress("217299911", new Address());
        System.out.println("StudentID: "+ studentAddress.getStudentId());
        assertEquals("217299911", studentAddress.getStudentId());
    }

    @Test
    public void validTest(){
        StudentAddress studentAddress = StudentAddressFactory.newStudentAddress("", new Address());
        assertNull(studentAddress.getStudentId());
        System.out.println(studentAddress);
    }

    @Disabled("Test Disabled")
    @Test

    public void disableTest(){
        StudentAddress studentAddress = StudentAddressFactory.newStudentAddress("217299911", new Address());
        assertSame("217299911", studentAddress.getStudentId());
    }

}
