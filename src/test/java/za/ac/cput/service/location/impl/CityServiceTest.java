/*
 * City Service Test
 * Author: Panashe Muinzani (218186568)
 * 16 June 2022
 */

package za.ac.cput.service.location.impl;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.location.City;
import za.ac.cput.domain.location.Country;
import za.ac.cput.factory.location.CityFactory;
import za.ac.cput.factory.location.CountryFactory;
import za.ac.cput.service.location.ICityService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CityServiceTest {
    private final Country country = CountryFactory.createCountry("SA", "South Africa");
    private final City city = CityFactory.createCity("CPT", "Cape Town", country);
    @Autowired
    private ICityService service;

    @Test
    void save() {
        City saved = this.service.save(this.city);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(this.city, saved)
        );
    }

    @Test
    void read() {
        Optional<City> read = this.service.read(this.city.getId());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.city, read.get())
        );
    }


    @Test
    void findAll() {
        List<City> cityList = this.service.findAll();
        System.out.println(cityList);
        assertEquals(1, cityList.size());
    }

    @Test
    void delete() {
        this.service.delete(this.city);
        List<City> cityList = this.service.findAll();
        assertEquals(0, cityList.size());
    }
}
