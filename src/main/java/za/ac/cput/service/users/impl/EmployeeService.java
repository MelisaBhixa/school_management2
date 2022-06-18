package za.ac.cput.service.users.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.users.Employee;
import za.ac.cput.service.users.IEmployeeService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Override
    public Employee save(Employee employee) {
        return null;
    }

    @Override
    public Optional<Employee> read(String s) {
        return Optional.empty();
    }

    @Override
    public void delete(Employee employee) {

    }

    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }
}
