package raf.ui.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import raf.ui.hospital.model.Specialization;

import java.util.Optional;

public interface SpecializationRepository extends JpaRepository<Specialization, Long> {

    Optional<Specialization> findSpecializationByName(String name);

}
