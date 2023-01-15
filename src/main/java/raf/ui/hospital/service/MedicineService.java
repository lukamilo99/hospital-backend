package raf.ui.hospital.service;

import raf.ui.hospital.model.Medicine;

import java.util.Optional;

public interface MedicineService {
    Optional<Medicine> findById(Long id);
}
