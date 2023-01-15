package raf.ui.hospital.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import raf.ui.hospital.model.Illness;
import raf.ui.hospital.repository.IllnessRepository;
import raf.ui.hospital.service.IllnessService;
import java.util.Optional;
@Service
@AllArgsConstructor
public class IllnessServiceImpl implements IllnessService {
    private IllnessRepository illnessRepository;
    @Override
    public Optional<Illness> findByName(String name) {
        return illnessRepository.findByName(name);
    }
}
