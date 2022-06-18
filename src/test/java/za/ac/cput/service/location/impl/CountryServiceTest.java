package za.ac.cput.service.location.impl;

/*
 *Country Service class
 *CountryService.java
 * Thina Mbiza: 217217095
 * Date: 18/06/2022
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.location.Country;
import za.ac.cput.factory.location.CountryFactory;
import za.ac.cput.service.location.ICountryService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CountryServiceTest {
    private final Country country = CountryFactory.createCountry("001","United States");
    @Autowired
    private ICountryService service;
    @Order(1)
    @Test
    void save() {
        Country saved = this.service.save(this.country);
        assertAll(
                ()->assertNotNull(saved),

                ()->assertEquals(this.country,saved)
        );
    }
    @Order(2)
    @Test
    void read() {
        Optional<Country> read = this.service.read(this.country.getId());
        System.out.println(read);
        assertAll(
                ()-> assertTrue(read.isPresent()),
                ()->assertEquals(this.country,read.get())
        );
    }
    @Order(4)
    @Test void delete(){
        this.service.delete(this.country);
        List<Country> countryList = this.service.findAll();
        assertEquals(0, countryList.size());
    }
    @Order(3)
    @Test
    void findAll() {
        List<Country> countryList = this.service.findAll();
        assertEquals(1,countryList.size());
    }
}