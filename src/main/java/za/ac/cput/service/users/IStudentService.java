/**
 IStudentService.java
 Entity for IStudentService
 Author: Zuko Fukula (217299911)
 Date: 13 June 2022
 */


package za.ac.cput.service.users;

import za.ac.cput.domain.users.Student;
import za.ac.cput.service.IService;

import java.util.List;
import java.util.Optional;

public interface IStudentService extends IService<Student, String> {
    List<Student> findAll();
    void deleteById(String id);
    Optional<Student> findByEmail(String email);
}
