package za.ac.cput.service.users;

import za.ac.cput.domain.users.Student;
import za.ac.cput.service.IService;

import java.util.List;

public interface IStudentService extends IService<Student, String> {
    List<Student> findAll();
    void deleteById(String id);
}
