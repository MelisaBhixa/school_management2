/**
 EmployeeFactory.java
 Factory for the Employee
 Author: Legiste Ndabashinze (217046207)
 Date: 12 June 2022
 */
package za.ac.cput.factory.users;

import za.ac.cput.domain.userInfo.Name;
import za.ac.cput.domain.users.Employee;
import za.ac.cput.util.Helper;

public class EmployeeFactory {
    public static Employee newEmployee(String staffId, String email, Name name){

        Helper.checkStringParam("staffId", staffId);
        Helper.checkStringParam("email", email);
        Helper.isObjectNull(name);
        Helper.isValidEmail(email);

        return new Employee.EmployeeBuilder()
                .setStaffId(staffId)
                .setEmail(email)
                .setName(name)
                .build();
    }
}
