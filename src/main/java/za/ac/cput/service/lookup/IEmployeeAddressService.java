package za.ac.cput.service.lookup;

import za.ac.cput.domain.lookup.EmployeeAddress;
import za.ac.cput.service.IService;

import java.util.List;
import java.util.Optional;

public interface IEmployeeAddressService extends IService<EmployeeAddress, String> {
    Optional<EmployeeAddress> findById(String id);
    void deleteById(String staffId);
    List<EmployeeAddress> findAll();
}
