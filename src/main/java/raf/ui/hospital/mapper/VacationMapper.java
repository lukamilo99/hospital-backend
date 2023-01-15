package raf.ui.hospital.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import raf.ui.hospital.dto.vacationDto.CreateVacationDto;
import raf.ui.hospital.dto.vacationDto.PresentVacationDto;
import raf.ui.hospital.model.Doctor;
import raf.ui.hospital.model.Vacation;
import raf.ui.hospital.service.DoctorService;

import java.util.Optional;

@Component
@AllArgsConstructor
public class VacationMapper {
    private DoctorService doctorService;
    public Vacation toVacation(CreateVacationDto dto){
        Vacation vacation = new Vacation();
        Optional<Doctor> doctor = doctorService.findDoctorEntityById(dto.getDoctorId());
        if(doctor.isPresent()) vacation.setEmployee(doctor.get());
        else{
            System.out.println("There is no employee with id " + dto.getDoctorId());
        }
        vacation.setFromDate(dto.getStartDate());
        vacation.setToDate(dto.getEndDate());

        return vacation;
    }

    public PresentVacationDto toDto(Vacation vacation){
        PresentVacationDto dto = new PresentVacationDto();
        dto.setDoctorId(vacation.getEmployee().getId());
        dto.setStartDate(vacation.getFromDate());
        dto.setEndDate(vacation.getToDate());

        return dto;
    }
}
