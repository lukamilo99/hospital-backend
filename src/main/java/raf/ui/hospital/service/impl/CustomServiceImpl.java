package raf.ui.hospital.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import raf.ui.hospital.dto.MedicineDto;
import raf.ui.hospital.mapper.MedicineMapper;
import raf.ui.hospital.repository.impl.QueryOneRepository;
import raf.ui.hospital.service.CustomService;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CustomServiceImpl implements CustomService {
    private QueryOneRepository customRepository;
    private MedicineMapper medicineMapper;

    @Override
    public List<MedicineDto> query1(String param) {
        return customRepository.findByIllnessList(param).stream().map(medicineMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<MedicineDto> query2(String param) {
        return customRepository.findByName(param).stream().map(medicineMapper::toDto).collect(Collectors.toList());
    }
}
