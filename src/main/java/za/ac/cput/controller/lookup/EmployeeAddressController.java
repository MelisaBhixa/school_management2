/**
 EmployeeAddressController.java
 Controller for the EmployeeAddress
 Author: Legiste Ndabashinze (217046207)
 Date: 17 June 2022
 */
package za.ac.cput.controller.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.lookup.EmployeeAddress;
import za.ac.cput.factory.lookup.EmployeeAddressFactory;
import za.ac.cput.service.lookup.IEmployeeAddressService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("school-management/employee-address")
public class EmployeeAddressController {

    private IEmployeeAddressService service;

    @Autowired
    public EmployeeAddressController(IEmployeeAddressService service){
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity<EmployeeAddress> save(@Valid @RequestBody EmployeeAddress employeeAddress){
        EmployeeAddress valEmployeeAddress;
        try {
            valEmployeeAddress = EmployeeAddressFactory.newEmployeeAddress(employeeAddress.getStaffId(), employeeAddress.getAddress());
        }
        catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        EmployeeAddress save = service.save(valEmployeeAddress);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{staffId}")
    public ResponseEntity<EmployeeAddress> read(@PathVariable String staffId){
        EmployeeAddress employeeAddress = this.service.read(staffId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(employeeAddress);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void>deleteById(@PathVariable String staffId) {
        this.service.deleteById(staffId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<EmployeeAddress>>findAll(){
        List <EmployeeAddress> employeeAddressList = this.service.findAll();
        return ResponseEntity.ok(employeeAddressList);

    }

}
