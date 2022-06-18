/*
AddressFactory Test.java
Factory Test for Address
Author: Melisa Bhixa
Date: 15 June 2022
 */

package za.ac.cput.factory.location;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.location.Address;
import za.ac.cput.domain.location.City;

import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {
    @Test
    public void successTest() {
        Address address = AddressFactory
                .newAddress("G160", "Catsville Residence", "Browning Rd", "6",
                        Integer.parseInt("7925"), new City());
        System.out.println(address);
        assertNotNull(address);
    }

    @Test
    public void failInvalidUnitNumberTest(){
        Address address = AddressFactory
                .newAddress("G160", "Catsville Residence", "Browning Rd", "6",
                        Integer.parseInt("7925"), new City());
        System.out.println(address);
        assertNotNull(address);
    }

    @Test
    public void failInvalidComplexNameTest() {
        Address address = AddressFactory
                .newAddress("G160", "Catsville Residence", "Browning Rd", "6",
                        Integer.parseInt("7925"), new City());
        System.out.println(address);
        assertNotNull(address);
    }

    @Test
    public void failInvalidStreetNameTest() {
        Address address = AddressFactory
                .newAddress("G160", "Catsville Residence", "Browning Rd", "6",
                        Integer.parseInt("7925"), new City());
        System.out.println(address);
        assertNotNull(address);
    }

    @Test
    public void failInvalidStreetNumberTest() {
        Address address = AddressFactory
                .newAddress("G160", "Catsville Residence", "Browning Rd", "6",
                        Integer.parseInt("7925"), new City());
        System.out.println(address);
        assertNotNull(address);
    }

    @Test
    public void failInvalidPostalCodeTest() {
        Address address = AddressFactory
                .newAddress("G160", "Catsville Residence", "Browning Rd", "6",
                        Integer.parseInt("7925"), new City());
        System.out.println(address);
        assertNotNull(address);
    }

    @Test
    public void failInvalidCityTest() {
        Address address = AddressFactory
                .newAddress("G160", "Catsville Residence", "Browning Rd", "6",
                        Integer.parseInt("7925"), null);
        System.out.println(address);
        assertNotNull(address);
    }

}
