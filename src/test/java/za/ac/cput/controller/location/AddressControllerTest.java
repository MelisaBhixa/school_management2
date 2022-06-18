/*
AddressControllerTest.java
Controller Test for Address
Author: Melisa Bhixa
Date: 18-06-2022
 */
package za.ac.cput.controller.location;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.location.Address;
import za.ac.cput.domain.location.City;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)

class AddressControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private AddressController controller;

    @Autowired
    private TestRestTemplate restTemplate;

    private Address address;
    private City city;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        city = new City.CityBuilder().setId("217131085").setName("Melisa").build();
        address = new Address.AddressBuilder().setUnitNumber("G160").setComplexName("catsville Residence").setStreetNumber("6").setStreetName("Browning Rd").setPostalCode(7925).setCity(city).build();

        this.baseUrl = "http://localhost:" + this.port + "school_management/address/";
    }

    @Test
    void save() {
        String url = baseUrl + "save/";
        System.out.println(url);
        ResponseEntity<Address> response = this.restTemplate
                .postForEntity(url, this.address, Address.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void read() {
        String url = baseUrl + "read/" + this.address.getStreetNumber();
        System.out.println(url);
        ResponseEntity<Address> response = this.restTemplate
                .getForEntity(url, Address.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void getALl() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Address[]> response = this.restTemplate
                .getForEntity(url, Address[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 1)
        );
    }


    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.address.getStreetNumber();
        this.restTemplate.delete(url);
    }

}