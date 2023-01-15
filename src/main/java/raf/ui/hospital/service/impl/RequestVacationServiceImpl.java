package raf.ui.hospital.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import raf.ui.hospital.dto.vacationDto.CreateVacationDto;
import raf.ui.hospital.repository.RequestVacationRepository;
import raf.ui.hospital.service.RequestVacationService;
@Service
@AllArgsConstructor
public class RequestVacationServiceImpl implements RequestVacationService {
    private RequestVacationRepository vacationRepository;
    @Override
    public boolean requestVacation(CreateVacationDto dto) {
        return vacationRepository.requestVacation(dto);
    }
}
