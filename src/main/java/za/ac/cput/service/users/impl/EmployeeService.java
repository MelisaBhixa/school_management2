package za.ac.cput.service.users.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.users.Employee;
import za.ac.cput.repository.users.IEmployeeRepository;
import za.ac.cput.service.users.IEmployeeService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    private final IEmployeeRepository repository;

    @Autowired
    public EmployeeService(IEmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee save(Employee employee) {
        return this.repository.save(employee);
    }

    @Override
    public Optional<Employee> read(String s) {
        return this.repository.findById(s);
    }

    @Override
    public void delete(Employee employee) {
        this.repository.delete(employee);
    }

    @Override
    public List<Employee> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        this.repository.deleteById(id);
    }
}
