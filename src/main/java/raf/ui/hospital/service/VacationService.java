package raf.ui.hospital.service;

import raf.ui.hospital.dto.vacationDto.CreateVacationDto;
import raf.ui.hospital.dto.vacationDto.PresentVacationDto;
import raf.ui.hospital.model.Vacation;

import java.sql.Date;

public interface VacationService {
    void saveVacation(CreateVacationDto vacation);
    void deleteVacationById(Long id);

}
