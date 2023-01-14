package raf.ui.hospital.service;

import raf.ui.hospital.model.Specialization;

import java.util.List;
import java.util.Optional;

public interface SpecializationService {
    Optional<Specialization> findByName(String name);
}
