package raf.ui.hospital.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import raf.ui.hospital.dto.ProcedureDto;
import raf.ui.hospital.mapper.MedicineMapper;
import raf.ui.hospital.mapper.ProcedureMapper;
import raf.ui.hospital.repository.impl.CustomRepositoryImpl;
import raf.ui.hospital.service.CustomService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CustomServiceImpl implements CustomService {
    private CustomRepositoryImpl customRepository;
    private ProcedureMapper procedureMapper;

    @Override
    public List<String[]> query1(String illness) {
        return customRepository.findMedicineByIllness(illness);
    }

    @Override
    public Long query3() {
        return customRepository.findCovidPatientsOnAntibioticsRatio();
    }

    @Override
    public Double query7(String firstName, String lastName) {
        return customRepository.findDoctorsWeeklyProcedureNumber(firstName, lastName);
    }

    @Override
    public List<ProcedureDto> query6() {
        return customRepository.findProceduresOrderByPrice().stream().map(procedureMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public String query5() {
        return customRepository.findDepartmentWithMostProcedures();
    }

    @Override
    public List<String[]> query4() {
        return customRepository.findNumberOfProceduresGroupBySpecialization();
    }

    @Override
    public String query2(String name) {
        return customRepository.findManufacturerByMedicineName(name).toString();
    }
}
