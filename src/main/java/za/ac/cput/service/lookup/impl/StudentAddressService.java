package za.ac.cput.service.lookup.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.lookup.StudentAddress;
import za.ac.cput.service.lookup.IStudentAddressService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentAddressService implements IStudentAddressService {
    @Override
    public StudentAddress save(StudentAddress studentAddress) {
        return null;
    }

    @Override
    public Optional<StudentAddress> read(String s) {
        return Optional.empty();
    }

    @Override
    public void delete(StudentAddress studentAddress) {

    }

    @Override
    public Optional<StudentAddress> findById(String id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(String studentId) {

    }

    @Override
    public List<StudentAddress> findAll() {
        return null;
    }
}
