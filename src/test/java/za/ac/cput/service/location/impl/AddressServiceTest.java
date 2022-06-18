/*
AddressService Test.java
Service Test for Address
Author: Melisa Bhixa
Date: 18 June 2022
 */

package za.ac.cput.service.location.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.location.Address;
import za.ac.cput.domain.location.City;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressServiceTest {
    private final City city = new City.CityBuilder()
            .setId("217131085")
            .setName("Melisa")
            .build();

    private final Address address = new Address.AddressBuilder()
            .setUnitNumber("G160")
            .setComplexName("Catsville Residence")
            .setStreetNumber("6")
            .setPostalCode(7925)
            .setCity(city)
            .build();

    @Autowired
    private AddressService service;
    private char[] Address;

    @Test
    void save() {
        Address saved = service.save(address);
        String address = String.valueOf(Address);
        String output = String.valueOf(saved);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(address, output)
        );
        System.out.println(saved);
    }


    @Test
    void read() {
        Address saved = service.save(address);
        Optional<Address> read = service.read(saved.getStreetNumber());
        System.out.println(read);
        String address = String.valueOf(saved);
        String output = String.valueOf(read.get());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(address, output)
        );
    }


    @Test
    void getAll() {
        Address saved = service.save(address);
        String staffId = saved.getStreetNumber();
        List<Address> AddressList = service.getAll(staffId);
        System.out.println(AddressList);
        assertSame(1, AddressList.size());
    }

    @Test
    void delete() {
        this.service.delete(address);
    }
}

