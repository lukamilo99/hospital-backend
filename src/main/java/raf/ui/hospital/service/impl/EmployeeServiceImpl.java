package raf.ui.hospital.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import raf.ui.hospital.model.Employee;
import raf.ui.hospital.repository.EmployeeRepository;
import raf.ui.hospital.service.EmployeeService;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Optional<Employee>> getEmployeesById(Long id) {
        return employeeRepository.getEmployeesById(id);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
