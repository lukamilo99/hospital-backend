package raf.ui.hospital.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import raf.ui.hospital.model.Medicine;
import raf.ui.hospital.repository.MedicineRepository;
import raf.ui.hospital.service.MedicineService;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MedicineServiceImpl implements MedicineService {
    private MedicineRepository medicineRepository;
    @Override
    public Optional<Medicine> findById(Long id) {
        return medicineRepository.findById(id);
    }
}
