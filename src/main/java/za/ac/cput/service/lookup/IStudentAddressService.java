/**
 IStudentAddressService.java
 Entity for IStudentAddressService
 Author: Zuko Fukula (217299911)
 Date: 13 June 2022
 */


package za.ac.cput.service.lookup;

import za.ac.cput.domain.lookup.StudentAddress;
import za.ac.cput.service.IService;

import java.util.List;
import java.util.Optional;

public interface IStudentAddressService extends IService<StudentAddress, String> {
    Optional<StudentAddress> findById(String id);
    void deleteById(String studentId);
    List<StudentAddress> findAll();
}
