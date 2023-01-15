package raf.ui.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import raf.ui.hospital.model.Vacation;

import java.util.Optional;

@Repository
public interface VacationRepository extends JpaRepository<Vacation, Long> {
    Optional<Vacation> findById(Long aLong);
}
