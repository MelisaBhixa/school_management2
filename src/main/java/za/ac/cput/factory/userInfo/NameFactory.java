/**
 NameFactory.java
 Factory for the Name
 Author: Legiste Ndabashinze (217046207)
 Date: 15 June 2022
 */
package za.ac.cput.factory.userInfo;

import za.ac.cput.domain.userInfo.Name;
import za.ac.cput.util.Helper;

public class NameFactory {
    public static Name newName(String firstName, String middleName, String lastName){

        Helper.checkStringParam("firstName", firstName);
        Helper.checkStringParam("lastName", lastName);
        Helper.setEmptyIfNull(middleName);

        return new Name.NameBuilder()
                .firstName(firstName)
                .middleName(middleName)
                .lastName(lastName)
                .build();
    }
}
