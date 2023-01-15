package raf.ui.hospital.service;

import raf.ui.hospital.dto.prescriptionDto.CreatePrescriptionDto;
import raf.ui.hospital.dto.prescriptionDto.PresentPrescriptionDto;
import raf.ui.hospital.model.Prescription;

public interface PrescriptionService {
    void savePrescription(CreatePrescriptionDto prescription);
    void deleteById(Long id);
    PresentPrescriptionDto findById(Long id);
}
