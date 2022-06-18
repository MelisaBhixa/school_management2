/**
 StudentAddresssController.java
 Controller Test for StudentAddress
 Author: Zuko Fukula (217299911)
 Date: 16 June 2022
 */


package za.ac.cput.controller.lookup;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.location.Address;
import za.ac.cput.domain.location.City;
import za.ac.cput.domain.location.Country;
import za.ac.cput.domain.lookup.StudentAddress;
import za.ac.cput.factory.location.AddressFactory;
import za.ac.cput.factory.location.CityFactory;
import za.ac.cput.factory.location.CountryFactory;
import za.ac.cput.factory.lookup.StudentAddressFactory;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentAddressControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private StudentAddressController controller;
    @Autowired private TestRestTemplate template;

    private Address address;
    private StudentAddress studentAddress;
    private String baseUrl;

    @BeforeEach
    void setUp(){
        assertNotNull(controller);
        Country country = CountryFactory.createCountry("+27", "South Africa");
        City city = CityFactory.createCity("111", "Cape town", country);
        Address address = AddressFactory.newAddress("77", "Reynolds", "Reynolds Street", "44", 7881, city);
        this.studentAddress = StudentAddressFactory.newStudentAddress("217299911",address);
        this.baseUrl = "http://localhost:" + this.port+ "/school-management/student-address/";
    }

    @Test
    @Order(1)
    void save(){
        String url = baseUrl + "save";
        ResponseEntity<StudentAddress> response = this.template
                .postForEntity(url,this.studentAddress, StudentAddress.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(2)
    void read(){
        String url = baseUrl + "read/" + this.studentAddress.getStudentId();
        System.out.println(url);
        ResponseEntity<StudentAddress> response = this.template.getForEntity(url,StudentAddress.class);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(4)
    void delete(){
        String url = baseUrl + "delete/"+ this.studentAddress.getStudentId();
        this.template.delete(url);
    }

    @Test
    @Order(3)
    void findAll(){
        String url = baseUrl + "all";
        ResponseEntity<StudentAddress[]>response =
                this.template.getForEntity(url,StudentAddress[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()-> assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertEquals(1, response.getBody().length)
        );
    }

}
