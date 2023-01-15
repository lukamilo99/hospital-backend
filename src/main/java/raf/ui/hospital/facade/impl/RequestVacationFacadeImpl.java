package raf.ui.hospital.facade.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import raf.ui.hospital.dto.vacationDto.CreateVacationDto;
import raf.ui.hospital.facade.RequestVacationFacade;
import raf.ui.hospital.service.RequestVacationService;
import raf.ui.hospital.service.VacationService;

@Component
@AllArgsConstructor
public class RequestVacationFacadeImpl implements RequestVacationFacade {
    private RequestVacationService requestVacationService;
    private VacationService vacationService;

    @Override
    public String requestVacation(CreateVacationDto dto) {
        boolean isPossibleToGetVacation = requestVacationService.requestVacation(dto);

        if (isPossibleToGetVacation){
            vacationService.saveVacation(dto);
            return "Your vacation has been approved";
        }
        else return "It is not possible to have vacation between " + dto.getStartDate() + " and " + dto.getEndDate();
    }
}
