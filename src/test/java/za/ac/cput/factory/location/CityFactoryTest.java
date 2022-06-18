package za.ac.cput.factory.location;
/*
 * City Factory Test
 * CityFactoryTest.java
 * Author: Panashe Muinzani (218186568)
 * 16 June 2022
 */

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import za.ac.cput.domain.location.City;
import za.ac.cput.domain.location.Country;


class CityFactoryTest {

    @Test
    public void successTest(){ //Creation of a City, Test should pass.
        Country country = CountryFactory.createCountry("South Africa", "2789");
        City city = CityFactory.createCity("7530", "Bellville", country);
        System.out.println(city);
        assertNotNull(city);
    }

    @Test
    public void failInvalidNameTest(){  //No City name provided, Test should fail
        Country country = CountryFactory.createCountry("South Africa", "2789");
        City city = CityFactory.createCity("7530", null, country);
        System.out.println(city);
        assertNotNull(city);
    }

    @Test
    public void failInvalidIdTest() { //No City Id provided, test should fail.
        Country country = CountryFactory.createCountry("South Africa", "2789");
        City city = CityFactory.createCity(" ", "Tygerberg", country);
        System.out.println(city);
        assertNotNull(city);
    }

    @Test
    public void failInvalidCountryTest() { //No Country name provided, test should fail.
        Country country = CountryFactory.createCountry("", "2789");
        City city = CityFactory.createCity("7447", "Tygerberg", country);
        System.out.println(city);
        assertNotNull(city);
    }

    @Disabled("Test Disabled")
    @Test
    public void disableTest(){
        Country country = CountryFactory.createCountry("South Africa", "2789");
        City city = CityFactory.createCity("7558", "Parow", country);
        assertSame("Parow", city.getName());
    }
}
