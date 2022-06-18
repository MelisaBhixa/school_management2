package za.ac.cput.service.lookup.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.lookup.EmployeeAddress;
import za.ac.cput.repository.lookup.IEmployeeAddressRepository;
import za.ac.cput.service.lookup.IEmployeeAddressService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeAddressService implements IEmployeeAddressService {

    private final IEmployeeAddressRepository repository;

    @Autowired
    public EmployeeAddressService(IEmployeeAddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeAddress save(EmployeeAddress employeeAddress) {
        return this.repository.save(employeeAddress);
    }

    @Override
    public Optional<EmployeeAddress> read(String s) {
        return this.repository.findById(s);
    }

    @Override
    public void delete(EmployeeAddress employeeAddress) {
        this.repository.delete(employeeAddress);
    }

    @Override
    public Optional<EmployeeAddress> findById(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void deleteById(String staffId) {
        this.repository.deleteById(staffId);
    }

    @Override
    public List<EmployeeAddress> findAll() {
        return this.repository.findAll();
    }
}
