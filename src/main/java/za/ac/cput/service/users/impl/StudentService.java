/**
 StudentService.java
 Entity for the StudentService
 Author: Zuko Fukula (217299911)
 Date: 13 June 2022
 */



package za.ac.cput.service.users.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.users.Student;
import za.ac.cput.repository.users.IStudentRepository;
import za.ac.cput.service.users.IStudentService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    private final IStudentRepository repository;

    @Autowired
    public StudentService(IStudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student save(Student student) {
        return this.repository.save(student);
    }

    @Override
    public Optional<Student> read(String s) {
        return this.repository.findById(s);
    }

    @Override
    public void delete(Student student) {this.repository.delete(student);}

    @Override
    public List<Student> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {this.repository.deleteById(id);}
}
