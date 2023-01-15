package raf.ui.hospital.service;

import raf.ui.hospital.model.Patient;

import java.util.Optional;

public interface PatientService {
    Optional<Patient> findById(Long id);
}
