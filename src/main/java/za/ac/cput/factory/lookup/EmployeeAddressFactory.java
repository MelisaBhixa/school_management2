/**
 EmployeeAddressFactory.java
 Factory for the EmployeeAddress
 Author: Legiste Ndabashinze (217046207)
 Date: 12 June 2022
 */
package za.ac.cput.factory.lookup;

import za.ac.cput.domain.location.Address;
import za.ac.cput.domain.lookup.EmployeeAddress;
import za.ac.cput.util.Helper;

public class EmployeeAddressFactory {
    public static EmployeeAddress newEmployeeAddress(String staffId, Address address){
        Helper.checkStringParam("staffId", staffId);
        Helper.isObjectNull(address);

        return new EmployeeAddress.EmployeeAddressBuilder()
                .setStaffId(staffId)
                .setAddress(address)
                .build();
    }
}
