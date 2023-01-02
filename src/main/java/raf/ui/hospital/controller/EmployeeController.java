package raf.ui.hospital.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import raf.ui.hospital.dto.DoctorCreateDto;
import raf.ui.hospital.mapper.DoctorMapper;
import raf.ui.hospital.model.Doctor;
import raf.ui.hospital.service.EmployeeService;
import raf.ui.hospital.service.SpecializationService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final SpecializationService specializationService;
    private final DoctorMapper doctorMapper;
    public EmployeeController(EmployeeService employeeService, SpecializationService specializationService, DoctorMapper doctorMapper) {
        this.employeeService = employeeService;
        this.specializationService = specializationService;
        this.doctorMapper = doctorMapper;
    }

    @GetMapping ("/find/{id}")
    public ResponseEntity<Doctor> findById(@PathVariable Long id){
        employeeService.getEmployeesById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/save/doctor")
    public ResponseEntity<DoctorCreateDto> saveDoctor(@RequestBody DoctorCreateDto doctorDto){
        employeeService.saveEmployee(doctorMapper.doctorDtoToDoctor(doctorDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
