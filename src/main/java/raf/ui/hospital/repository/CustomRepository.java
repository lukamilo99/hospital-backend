package raf.ui.hospital.repository;

import org.springframework.data.repository.Repository;
import raf.ui.hospital.model.Medicine;

import java.util.List;
public interface CustomRepository extends Repository<Medicine, Long> {

    List<Medicine> findByIllnessList(String param);
    List<Medicine> findByName(String param);
}
