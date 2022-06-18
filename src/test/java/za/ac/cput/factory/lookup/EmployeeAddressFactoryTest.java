package za.ac.cput.factory.lookup;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.location.Address;
import za.ac.cput.domain.lookup.EmployeeAddress;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeAddressFactoryTest {
    @Test
    public void successTest(){
        EmployeeAddress employeeAddress = EmployeeAddressFactory
                .newEmployeeAddress("217046207", new Address()); // TODO: 2022/06/14 Implement proper Address instance.

        System.out.println(employeeAddress);
        assertNotNull(employeeAddress);
    }

    @Test
    public void failInvalidStaffIdTest(){// Empty StaffId provided... TEST IS SUPPOSED TO FAIL
        EmployeeAddress employeeAddress = EmployeeAddressFactory
                .newEmployeeAddress("", new Address());// TODO: 2022/06/14 Implement proper Address instance.

        System.out.println(employeeAddress);
        assertNotNull(employeeAddress);
    }

    @Test
    public void failNullAddressTest(){// Null value is provided instead of class object... TEST IS SUPPOSED TO FAIL
        EmployeeAddress employeeAddress = EmployeeAddressFactory
                .newEmployeeAddress("217046207", null);

        System.out.println(employeeAddress);
        assertNotNull(employeeAddress);
    }
}