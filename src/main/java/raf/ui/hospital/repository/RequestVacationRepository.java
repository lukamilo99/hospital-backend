package raf.ui.hospital.repository;


import raf.ui.hospital.dto.vacationDto.CreateVacationDto;

public interface RequestVacationRepository {
    boolean requestVacation(CreateVacationDto dto);
}
