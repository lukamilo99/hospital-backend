package raf.ui.hospital.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import raf.ui.hospital.dto.prescriptionDto.CreatePrescriptionDto;
import raf.ui.hospital.dto.prescriptionDto.PresentPrescriptionDto;
import raf.ui.hospital.mapper.PrescriptionMapper;
import raf.ui.hospital.model.Prescription;
import raf.ui.hospital.repository.PatientRepository;
import raf.ui.hospital.repository.PrescriptionRepository;
import raf.ui.hospital.service.PrescriptionService;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PrescriptionServiceImpl implements PrescriptionService {
    private PrescriptionRepository prescriptionRepository;
    private PrescriptionMapper prescriptionMapper;
    private final PatientRepository patientRepository;

    @Override
    public PresentPrescriptionDto findById(Long id) {
        Optional<Prescription> prescription = prescriptionRepository.findById(id);
        if(prescription.isPresent()){
            return prescriptionMapper.toDto(prescription.get());
        }
        else{
            System.out.println("There is no prescription with id " + id);
            return new PresentPrescriptionDto();
        }
    }
    @Override
    public void savePrescription(CreatePrescriptionDto dto) {
        Prescription prescription = prescriptionMapper.toPrescription(dto);
        prescriptionRepository.save(prescription);
    }
    @Override
    public void deleteById(Long id) {
        prescriptionRepository.deleteById(id);
    }
}
