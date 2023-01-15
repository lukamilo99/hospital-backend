package raf.ui.hospital.service;

import raf.ui.hospital.dto.vacationDto.CreateVacationDto;

public interface RequestVacationService {
    boolean requestVacation(CreateVacationDto dto);
}
