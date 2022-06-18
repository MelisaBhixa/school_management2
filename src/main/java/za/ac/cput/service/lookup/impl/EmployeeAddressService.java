package za.ac.cput.service.lookup.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.lookup.EmployeeAddress;
import za.ac.cput.service.lookup.IEmployeeAddressService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeAddressService implements IEmployeeAddressService {
    @Override
    public EmployeeAddress save(EmployeeAddress employeeAddress) {
        return null;
    }

    @Override
    public Optional<EmployeeAddress> read(String s) {
        return Optional.empty();
    }

    @Override
    public void delete(EmployeeAddress employeeAddress) {

    }

    @Override
    public Optional<EmployeeAddress> findById(String id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(String staffId) {

    }

    @Override
    public List<EmployeeAddress> findAll() {
        return null;
    }
}
