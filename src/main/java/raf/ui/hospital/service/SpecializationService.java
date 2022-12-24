package raf.ui.hospital.service;

import raf.ui.hospital.model.Specialization;

import java.util.Optional;

public interface SpecializationService {

    Optional<Specialization> findSpecializationByName(String name);
}
