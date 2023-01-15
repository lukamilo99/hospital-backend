package raf.ui.hospital.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import raf.ui.hospital.dto.doctorDto.CreateDoctorDto;
import raf.ui.hospital.dto.doctorDto.PresentDoctorDto;
import raf.ui.hospital.mapper.DoctorMapper;
import raf.ui.hospital.model.Doctor;
import raf.ui.hospital.repository.DoctorRepository;
import raf.ui.hospital.service.DoctorService;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private DoctorRepository doctorRepository;
    private DoctorMapper doctorMapper;
    @Override
    public void save(CreateDoctorDto doctorDto) {
        Doctor newDoctor = doctorMapper.toDoctor(doctorDto);
        doctorRepository.save(newDoctor);
    }

    @Override
    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public Optional<Doctor> findDoctorEntityById(Long id) {
        return doctorRepository.findById(id);
    }

    @Override
    public PresentDoctorDto findDoctorById(Long id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if(doctor.isPresent()) return doctorMapper.toPresentDto(doctor.get());
        else{
            System.out.println("There is no doctor with id " + id);
            return new PresentDoctorDto();
        }
    }
}
