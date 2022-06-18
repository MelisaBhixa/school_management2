package za.ac.cput.factory.location;

/*
 *CountryFactory class
 *CountryFactory.java
 * Thina Mbiza: 217217095
 * Date: 18/06/2022
 */

import za.ac.cput.domain.location.Country;

public class CountryFactory {
    public static Country build (String id, String name){
        if(id ==null || id.isEmpty() )
            throw new IllegalArgumentException("Country Id is required!");
        if(name ==null|| name.isEmpty() )
            throw new IllegalArgumentException("Country Name is required!");
        return new Country.Builder().setId(id)
                .setName(name).build();
    }

}

