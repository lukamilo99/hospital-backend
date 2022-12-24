package raf.ui.hospital.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import raf.ui.hospital.model.Specialization;
import raf.ui.hospital.repository.SpecializationRepository;
import raf.ui.hospital.service.SpecializationService;

import java.util.Optional;

@Service
@Transactional
public class SpecializationServiceImpl implements SpecializationService {
    private final SpecializationRepository specializationRepository;

    public SpecializationServiceImpl(SpecializationRepository specializationRepository) {
        this.specializationRepository = specializationRepository;
    }

    @Override
    public Optional<Specialization> findSpecializationByName(String name) {
        return specializationRepository.findSpecializationByName(name);
    }
}
