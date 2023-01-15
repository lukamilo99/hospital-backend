package raf.ui.hospital.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import raf.ui.hospital.model.Patient;
import raf.ui.hospital.repository.PatientRepository;
import raf.ui.hospital.service.PatientService;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService{
    private PatientRepository patientRepository;
    @Override
    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }
}
