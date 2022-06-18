/**
 StudentAddressController.java
 Controller for StudentAddress
 Author: Zuko Fukula (217299911)
 Date: 16 June 2022
 */
package za.ac.cput.controller.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.lookup.StudentAddress;
import za.ac.cput.factory.lookup.StudentAddressFactory;
import za.ac.cput.service.lookup.IStudentAddressService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("school-management/student-address")
public class StudentAddressController {

    private IStudentAddressService service;

    @Autowired
    public StudentAddressController(IStudentAddressService service){
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity<StudentAddress> save(@Valid @RequestBody StudentAddress studentAddress){
        StudentAddress valStudentAddress;
        try {
            valStudentAddress = StudentAddressFactory.newStudentAddress(studentAddress.getStudentId(), studentAddress.getAddress());
        }
        catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        StudentAddress save = service.save(valStudentAddress);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{studentId}")
    public ResponseEntity<StudentAddress> read(@PathVariable String studentId){
        StudentAddress studentAddress = this.service.read(studentId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(studentAddress);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void>deleteById(@PathVariable String studentId) {
        this.service.deleteById(studentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<StudentAddress>>findAll(){
        List <StudentAddress> studentAddressList = this.service.findAll();
        return ResponseEntity.ok(studentAddressList);

    }

}
