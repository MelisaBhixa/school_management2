/**
 StudentAddressServiceTest.java
 Entity for StudentAddressServiceTest
 Author: Zuko Fukula (217299911)
 Date: 13 June 2022
 */

package za.ac.cput.service.lookup.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.location.Address;
import za.ac.cput.domain.location.City;
import za.ac.cput.domain.location.Country;
import za.ac.cput.domain.lookup.StudentAddress;
import za.ac.cput.factory.location.AddressFactory;
import za.ac.cput.factory.location.CityFactory;
import za.ac.cput.factory.location.CountryFactory;
import za.ac.cput.factory.lookup.StudentAddressFactory;
import za.ac.cput.service.lookup.IStudentAddressService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class StudentAddressServiceTest {
    private Country country = CountryFactory.createCountry("+27", "South Africa");
    private City city = CityFactory.createCity("011", "Cape town", country);
    private Address address = AddressFactory.newAddress("77","Reynolds","Reynolds Street", "44",7881, city);
    private final StudentAddress studentAddress = StudentAddressFactory.newStudentAddress("217299911", address);

    @Autowired
    private IStudentAddressService studentAddressService;

    @Order(1)
    @Test
    void save() {
        StudentAddress saved = this.studentAddressService.save(this.studentAddress);
        assertEquals(this.studentAddress, saved);
        System.out.println(saved);
    }

    @Order(2)
    @Test
    void read() {
        Optional<StudentAddress> read = this.studentAddressService.read(this.studentAddress.getStudentId());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.studentAddress, read.get())
        );
    }

    @Order(3)
    @Test
    void findAll(){
        List<StudentAddress> studentAddressList = this.studentAddressService.findAll();
        assertEquals(1, studentAddressList.size());
    }

    @Order(4)
    @Test
    void delete() {
        this.studentAddressService.deleteById(this.studentAddress.getStudentId());
        List<StudentAddress> studentAddressList = this.studentAddressService.findAll();
        assertEquals(0, studentAddressList.size());
    }

}
