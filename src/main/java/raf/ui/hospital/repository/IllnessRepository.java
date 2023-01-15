package raf.ui.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import raf.ui.hospital.model.Illness;
import java.util.Optional;
@Repository
public interface IllnessRepository extends JpaRepository<Illness, Long> {
    Optional<Illness> findByName(String name);
}
