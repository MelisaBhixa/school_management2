package za.ac.cput.repository.lookup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.lookup.StudentAddress;

@Repository
public interface IStudentAddressRepository extends JpaRepository<StudentAddress, String> {
}
