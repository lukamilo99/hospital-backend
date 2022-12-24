package raf.ui.hospital.service;

import raf.ui.hospital.model.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Optional<Employee>> getEmployeesById(Long id);

    void saveEmployee(Employee employee);
}
