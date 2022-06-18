/**
 StudentAddressService.java
 Entity for the StudentAddressService
 Author: Zuko Fukula (217299911)
 Date: 13 June 2022
 */

package za.ac.cput.service.lookup.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.lookup.StudentAddress;
import za.ac.cput.repository.lookup.IStudentAddressRepository;
import za.ac.cput.service.lookup.IStudentAddressService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentAddressService implements IStudentAddressService {

    private final IStudentAddressRepository repository;

    @Autowired
    public StudentAddressService(IStudentAddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentAddress save(StudentAddress studentAddress) {
        return this.repository.save(studentAddress);
    }

    @Override
    public Optional<StudentAddress> read(String s) {
        return this.repository.findById(s);
    }

    @Override
    public void delete(StudentAddress studentAddress) {this.repository.delete(studentAddress);}

    @Override
    public Optional<StudentAddress> findById(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void deleteById(String studentId) {this.repository.deleteById(studentId);}

    @Override
    public List<StudentAddress> findAll() {
        return this.repository.findAll();
    }
}
