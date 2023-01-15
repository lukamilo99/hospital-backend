package raf.ui.hospital.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import raf.ui.hospital.dto.doctorDto.CreateDoctorDto;
import raf.ui.hospital.dto.doctorDto.PresentDoctorDto;
import raf.ui.hospital.model.Doctor;
import raf.ui.hospital.model.Specialization;
import raf.ui.hospital.service.SpecializationService;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Component
@AllArgsConstructor
public class DoctorMapper {
    private SpecializationService specializationService;
    public PresentDoctorDto toPresentDto(Doctor doctor){
        PresentDoctorDto dto = new PresentDoctorDto();
        dto.setFirstName(doctor.getFirstName());
        dto.setLastName(doctor.getLastName());
        doctor.getSpecializationList().forEach(specialization -> dto.addSpecialization(specialization.getName()));

        return dto;
    }

    public Doctor toDoctor(CreateDoctorDto dto){
        Doctor doctor = new Doctor();
        for(String specializationName: dto.getListOfSpecializations()){
            Optional<Specialization> specialization = specializationService.findByName(specializationName);
            if(specialization.isPresent()) doctor.addSpecialization(specialization.get());
            else System.out.println("There is no specialization with given name");
        }
        doctor.setFirstName(dto.getFirstName());
        doctor.setLastName(dto.getLastName());
        doctor.setHireDate(Date.valueOf(LocalDate.now()));
        doctor.setOnVacation(false);

        return doctor;
    }
}
