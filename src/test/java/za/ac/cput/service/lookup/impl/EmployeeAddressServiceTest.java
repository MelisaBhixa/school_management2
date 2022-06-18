package za.ac.cput.service.lookup.impl;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.location.Address;
import za.ac.cput.domain.location.City;
import za.ac.cput.domain.location.Country;
import za.ac.cput.domain.lookup.EmployeeAddress;
import za.ac.cput.factory.location.AddressFactory;
import za.ac.cput.factory.location.CityFactory;
import za.ac.cput.factory.location.CountryFactory;
import za.ac.cput.factory.lookup.EmployeeAddressFactory;
import za.ac.cput.service.lookup.IEmployeeAddressService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeAddressServiceTest {
    private Country country = CountryFactory.createCountry("+27", "South Africa");
    private City city = CityFactory.createCity("021", "Cape town", country);
    private Address address = AddressFactory.newAddress("123","A Complex Name","My Street Name", "456",7570, city);
    private final EmployeeAddress employeeAddress = EmployeeAddressFactory.newEmployeeAddress("emp_id", address);

    @Autowired
    private IEmployeeAddressService employeeAddressService;

    @Order(1)
    @Test
    void save() {
        EmployeeAddress saved = this.employeeAddressService.save(this.employeeAddress);
        assertEquals(this.employeeAddress, saved);
        System.out.println(saved);
    }

    @Order(2)
    @Test
    void read() {
        Optional<EmployeeAddress> read = this.employeeAddressService.read(this.employeeAddress.getStaffId());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.employeeAddress, read.get())
        );
    }

    @Order(3)
    @Test
    void findAll(){
        List<EmployeeAddress> employeeAddressList = this.employeeAddressService.findAll();
        assertEquals(1, employeeAddressList.size());
    }

    @Order(4)
    @Test
    void delete() {
        this.employeeAddressService.deleteById(this.employeeAddress.getStaffId());
        List<EmployeeAddress> employeeAddressList = this.employeeAddressService.findAll();
        assertEquals(0, employeeAddressList.size());
    }

}