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
import za.ac.cput.domain.lookup.EmployeeAddress;
import za.ac.cput.factory.location.AddressFactory;
import za.ac.cput.factory.location.CityFactory;
import za.ac.cput.factory.location.CountryFactory;
import za.ac.cput.factory.lookup.EmployeeAddressFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeAddressControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private EmployeeAddressController controller;
    @Autowired private TestRestTemplate template;

    private Address address;
    private EmployeeAddress employeeAddress;
    private String baseUrl;

    @BeforeEach
    void setUp(){
        assertNotNull(controller);
        Country country = CountryFactory.createCountry("+27", "South Africa");
        City city = CityFactory.createCity("021", "Cape town", country);
        Address address = AddressFactory.newAddress("123", "Complex Name", "A Street Name", "456", 7570, city);
        this.employeeAddress = EmployeeAddressFactory.newEmployeeAddress("21704620",address);
        this.baseUrl = "http://localhost:" + this.port+ "/school-management/employee-address/";
    }

    @Test
    @Order(1)
    void save(){
        String url = baseUrl + "save";
        ResponseEntity<EmployeeAddress> response = this.template
                .postForEntity(url,this.employeeAddress, EmployeeAddress.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(2)
    void read(){
        String url = baseUrl + "read/" + this.employeeAddress.getStaffId();
        System.out.println(url);
        ResponseEntity<EmployeeAddress> response = this.template.getForEntity(url,EmployeeAddress.class);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(4)
    void delete(){
        String url = baseUrl + "delete/"+ this.employeeAddress.getStaffId();
        this.template.delete(url);
    }

    @Test
    @Order(3)
    void findAll(){
        String url = baseUrl + "all";
        ResponseEntity<EmployeeAddress[]>response =
                this.template.getForEntity(url,EmployeeAddress[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()-> assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertEquals(1, response.getBody().length)
        );
    }

}