package raf.ui.hospital.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import raf.ui.hospital.model.Specialization;
import raf.ui.hospital.repository.SpecializationRepository;
import raf.ui.hospital.service.SpecializationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SpecializationServiceImpl implements SpecializationService {
    private SpecializationRepository specializationRepository;
    @Override
    public Optional<Specialization> findByName(String name) {
        return specializationRepository.findByName(name);
    }
}
