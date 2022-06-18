package za.ac.cput.repository.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.users.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, String> {
}
