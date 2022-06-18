package za.ac.cput.service.users.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.users.Student;
import za.ac.cput.service.users.IStudentService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    @Override
    public Student save(Student student) {
        return null;
    }

    @Override
    public Optional<Student> read(String s) {
        return Optional.empty();
    }

    @Override
    public void delete(Student student) {

    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }
}
