package raf.ui.hospital.mapper;

import org.springframework.stereotype.Component;
import raf.ui.hospital.dto.DoctorCreateDto;
import raf.ui.hospital.model.Doctor;
import raf.ui.hospital.model.Specialization;
import raf.ui.hospital.service.SpecializationService;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorMapper {
    private final SpecializationService specializationService;

    public DoctorMapper(SpecializationService specializationService) {
        this.specializationService = specializationService;
    }

    public DoctorCreateDto doctorToDoctorDto(Doctor doctor){
        DoctorCreateDto doctorDto = new DoctorCreateDto();
        doctorDto.setFirstName(doctor.getFirstName());
        doctorDto.setLastName(doctor.getLastName());
        doctorDto.setSpecializations(List.of((doctor.getSpecializations().get(doctor.getSpecializations().size() - 1)).getName()));
        return doctorDto;
    }

    public Doctor doctorDtoToDoctor(DoctorCreateDto doctorDto){
        Doctor doctor = new Doctor();
        doctor.setFirstName(doctorDto.getFirstName());
        doctor.setLastName(doctorDto.getLastName());

        List<Specialization> specializations = new ArrayList<>();

        for(String spec: doctorDto.getSpecializations()){
            specializations.add(specializationService.findSpecializationByName(spec).get());
        }

        doctor.setSpecializations(specializations);
        return doctor;
    }
}
