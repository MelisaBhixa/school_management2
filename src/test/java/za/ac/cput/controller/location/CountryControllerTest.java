package za.ac.cput.controller.location;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.location.Country;
import za.ac.cput.factory.location.CountryFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CountryControllerTest {
//    @LocalServerPort
//  private int port;

    @Autowired
    private CountryController controller;


    private static Country country = CountryFactory.createCountry("SA", "South Africa");

    void setUp(){
        assertNotNull(controller);
        this.country = CountryFactory
                .createCountry("SA", "South Africa");
    }

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseUrl = "http://localhost:3306/country";


//    private Country country;
//    private String baseUrl;

//    @BeforeEach
//    void setUp(){
//       assertNotNull(controller);
//        this.country = CountryFactory
//                .build("SA","South Africa");
//        this.baseUrl = "http://localhost:3306/country";
//    }

    @Test
    @Order(1)
    void save(){
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Country> response = this.restTemplate
                .postForEntity(url,this.country,Country.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );

    }
    @Test
    @Order(2)
    void read(){
        String url = baseUrl + "read/" + this.country.getId();
        System.out.println(url);
        ResponseEntity<Country> response = this.restTemplate.getForEntity(url,Country.class);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }
    @Test
    @Order(3)
    void delete(){
        String url = baseUrl + "delete/"+ this.country.getId();
        this.restTemplate.delete(url);
    }
    @Test
    @Order(4)
    void findAll(){
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Country[]>response =
                this.restTemplate.getForEntity(url,Country[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()-> assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertTrue(response.getBody().length==0)
        );
    }

}