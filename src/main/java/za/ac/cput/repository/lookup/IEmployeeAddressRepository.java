package za.ac.cput.repository.lookup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.lookup.EmployeeAddress;

@Repository
public interface IEmployeeAddressRepository extends JpaRepository<EmployeeAddress, String> {
}
