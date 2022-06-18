package za.ac.cput.repository.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.users.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, String> {
}
