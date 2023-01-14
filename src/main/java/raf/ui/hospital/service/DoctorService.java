package raf.ui.hospital.service;

import raf.ui.hospital.dto.doctorDto.CreateDoctorDto;
import raf.ui.hospital.dto.doctorDto.PresentDoctorDto;
import raf.ui.hospital.model.Doctor;

import java.util.Optional;

public interface DoctorService {

    void save(CreateDoctorDto doctorDto);
    void deleteDoctorById(Long id);
    PresentDoctorDto findDoctorById(Long id);




}
