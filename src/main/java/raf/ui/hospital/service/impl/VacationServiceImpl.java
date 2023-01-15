package raf.ui.hospital.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import raf.ui.hospital.dto.vacationDto.CreateVacationDto;
import raf.ui.hospital.mapper.VacationMapper;
import raf.ui.hospital.repository.VacationRepository;
import raf.ui.hospital.service.VacationService;

@Service
@AllArgsConstructor
public class VacationServiceImpl implements VacationService {
    private VacationRepository vacationRepository;
    private VacationMapper vacationMapper;
    @Override
    public void saveVacation(CreateVacationDto vacation) {
        vacationRepository.save(vacationMapper.toVacation(vacation));
    }

    @Override
    public void deleteVacationById(Long id) {
        vacationRepository.deleteById(id);
    }
}
