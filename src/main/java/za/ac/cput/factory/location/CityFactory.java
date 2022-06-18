package za.ac.cput.factory.location;
/*
 * City Factory Test
 * CityFactoryTest.java
 * Author: Panashe Muinzani (218186568)
 * 16 June 2022
 */

import za.ac.cput.domain.location.City;
import za.ac.cput.domain.location.Country;
import za.ac.cput.util.Helper;

public class CityFactory {
    public static City createCity (String id, String name, Country country){

        Helper.checkStringParam("id", id);
        Helper.checkStringParam("name", name);
        Helper.isObjectNull(country);
        Helper.isObjectNull(name);
//        Helper.isValidId(id);

        return new City.CityBuilder()
                .setId(id)
                .setName(name)
                .setCountry(country)
                .build();
    }
}
