/**
 StudentController.java
 Controller for Student
 Author: Zuko Fukula (217299911)
 Date: 16 June 2022
 */
package za.ac.cput.controller.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.userInfo.Name;
import za.ac.cput.domain.users.Student;
import za.ac.cput.factory.users.StudentFactory;
import za.ac.cput.service.users.IStudentService;
import za.ac.cput.util.Helper;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("school-management/student/")
public class StudentController {

    private final IStudentService service;

    @Autowired
    public StudentController(IStudentService service){
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity<Student> save(@Valid @RequestBody Student student){
        Student students;
        try {
            students = StudentFactory.newStudent(student.getStudentId(), student.getEmail(),student.getName());
        }
        catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Student save = service.save(students);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{studentId}")
    public ResponseEntity<Student> read(@PathVariable String studentId){
        Student student = this.service.read(studentId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void>deleteById(@PathVariable String studentId) {
        this.service.deleteById(studentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Student>>findAll(){
        List <Student> student = this.service.findAll();
        return ResponseEntity.ok(student);
    }

    @GetMapping("read-by-email/{email}")
    public ResponseEntity<Name> findByEmail(@PathVariable String email) {
        try {
            Helper.isValidEmail(email);
        }
        catch(IllegalArgumentException iae) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Student student = this.service.findByEmail(email)
                .orElseThrow(
                        ()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(student.getName());
    }

}
