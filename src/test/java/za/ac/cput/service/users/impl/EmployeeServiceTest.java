package za.ac.cput.service.users.impl;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.userInfo.Name;
import za.ac.cput.domain.users.Employee;
import za.ac.cput.factory.userInfo.NameFactory;
import za.ac.cput.factory.users.EmployeeFactory;
import za.ac.cput.service.users.IEmployeeService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    private final Name name = NameFactory.newName("Legiste", "AMiddleName", "Ndabashinze");
    private final Employee employee = EmployeeFactory.newEmployee("217046207","email@emial.com", name);

    @Autowired
    private IEmployeeService service;

    @Order(1)
    @Test
    void save() {
        Employee saved = this.service.save(this.employee);
        assertAll(
                ()->assertNotNull(saved),
                ()->assertEquals(this.employee,saved)
        );
    }

    @Order(2)
    @Test
    void read() {
        Optional<Employee> read = this.service.read(this.employee.getStaffId());
        System.out.println(read);
        assertAll(
                ()-> assertTrue(read.isPresent()),
                ()->assertEquals(this.employee,read.get())
        );
    }

    @Order(3)
    @Test
    void findAll() {
        List<Employee> employeeList = this.service.findAll();
        assertEquals(1,employeeList.size());
    }

    @Test
    @Order(4)
    void findByEmail() {
        String email = this.employee.getEmail();
        Optional <Employee> read = this.service.findByEmail(employee.getEmail());
        System.out.println(read);
        assertAll(
                ()-> assertTrue(read.isPresent()),
                ()->assertEquals(this.employee,read.get())
        );
    }

}