/**
 IStudentRepository.java
 Entity for IStudentRepository
 Author: Zuko Fukula (217299911)
 Date: 13 June 2022
 */

package za.ac.cput.repository.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.users.Student;

import java.util.Optional;

@Repository
public interface IStudentRepository extends JpaRepository<Student, String> {
    Optional<Student> findByEmail(String email);
}
