/* AddressFactory.java
 * Factory for Address
 * Author: Melisa Bhixa
 * Date: 14 June 2022
 */

package za.ac.cput.factory.location;

import za.ac.cput.domain.location.Address;
import za.ac.cput.domain.location.City;

public class AddressFactory {
    public static Address newAddress(String unitNumber, String complexName, String streetName, String streetNumber,
                                     int postalCode, City city) {

        return new Address.AddressBuilder()
                .setCity(city)
                .setUnitNumber(unitNumber)
                .setComplexName(complexName)
                .setStreetName(streetName)
                .setStreetNumber(streetNumber)
                .setPostalCode(postalCode)
                .build();
    }
}

