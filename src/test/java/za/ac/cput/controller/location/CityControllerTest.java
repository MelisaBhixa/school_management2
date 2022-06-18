/* CityControllerTest.java Class
 * Entity for City Controller Test
 * Author: Panashe Muinzani(218186568)
 * Date: 17 June 2022
 */


package za.ac.cput.controller.location;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.location.City;
import za.ac.cput.domain.location.Country;
import za.ac.cput.factory.location.CityFactory;
import za.ac.cput.factory.location.CountryFactory;

import static org.junit.jupiter.api.Assertions.*;

    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
    @TestMethodOrder(MethodOrderer.MethodName.class)
    public class CityControllerTest {

        @LocalServerPort
        private int port;

        @Autowired
        private CityController controller;
        @Autowired
        private TestRestTemplate restTemplate;

        private Country country;
        private City city;
        private String baseUrl;


        @BeforeEach
        void setUp() {
            this.country = CountryFactory.createCountry("Angola", "ANG");
            this.city = CityFactory.createCity("LSK", "Lusaka", country);
            this.baseUrl = "http://localhost:" + this.port + "/school_management/city/";
        }

        @Order(1)
        @Test
        void save() {
            String url = baseUrl + "/save";
            System.out.println(url);
            ResponseEntity<City> response = this.restTemplate
                    .postForEntity(url, this.city, City.class);
            System.out.println(response);
            assertAll(
                    () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                    () -> assertNotNull(response.getBody())
            );
        }

        @Order(2)
        @Test
        void read() {
            String url = baseUrl + "read/" + this.city.getId();
            ResponseEntity<City> response = this.restTemplate.getForEntity(url, City.class);
            assertAll(
                    ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                    ()-> assertNotNull(response.getBody())
            );
        }

        @Order(3)
        @Test
        void delete() {
            String url = baseUrl + "delete/"+ this.city.getId();
            this.restTemplate.delete(url);
        }

        @Order(4)
        @Test
        void findAll() {
            String url = baseUrl + "all";
            ResponseEntity<City[]> response = this.restTemplate.getForEntity(url, City[].class);
            System.out.println(response.getBody());
            assertAll(
                    () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                    () -> assertTrue(response.getBody().length == 0)
            );
        }

}