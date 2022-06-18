/**
 EmployeeController.java
 Controller for the Employee
 Author: Legiste Ndabashinze (217046207)
 Date: 17 June 2022
 */
package za.ac.cput.controller.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.userInfo.Name;
import za.ac.cput.domain.users.Employee;
import za.ac.cput.factory.users.EmployeeFactory;
import za.ac.cput.service.users.IEmployeeService;
import za.ac.cput.util.Helper;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("school-management/employee/")
public class EmployeeController {

    private final IEmployeeService service;

    @Autowired
    public EmployeeController(IEmployeeService service){
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity<Employee> save(@Valid @RequestBody Employee employee){
        Employee employee1;
        try {
            employee1 = EmployeeFactory.newEmployee(employee.getStaffId(), employee.getEmail(),employee.getName());
        }
        catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Employee save = service.save(employee1);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{staffId}")
    public ResponseEntity<Employee> read(@PathVariable String staffId){
        Employee employee = this.service.read(staffId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void>deleteById(@PathVariable String staffId) {
        this.service.deleteById(staffId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Employee>>findAll(){
        List <Employee> employee = this.service.findAll();
        return ResponseEntity.ok(employee);
    }

    @GetMapping("read-by-email/{email}")
    public ResponseEntity<Name> findByEmail(@PathVariable String email) {
        try {
            Helper.isValidEmail(email);
        }
        catch(IllegalArgumentException iae) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Employee employee = this.service.findByEmail(email)
                .orElseThrow(
                        ()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(employee.getName());
    }

}
