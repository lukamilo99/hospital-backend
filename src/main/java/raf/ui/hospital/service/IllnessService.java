package raf.ui.hospital.service;

import raf.ui.hospital.model.Illness;
import java.util.Optional;
public interface IllnessService {
    Optional<Illness> findByName(String name);
}
