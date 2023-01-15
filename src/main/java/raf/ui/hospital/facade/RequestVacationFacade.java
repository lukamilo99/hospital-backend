package raf.ui.hospital.facade;

import raf.ui.hospital.dto.vacationDto.CreateVacationDto;

public interface RequestVacationFacade {
    public String requestVacation(CreateVacationDto dto);
}
