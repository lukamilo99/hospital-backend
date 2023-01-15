package raf.ui.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import raf.ui.hospital.model.Medicine;
import java.util.Optional;
@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {

    Optional<Medicine> findById(Long aLong);
}
