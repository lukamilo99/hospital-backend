package raf.ui.hospital.repository;

import raf.ui.hospital.model.Medicine;
import java.util.List;
public interface CustomRepository {

    List<Medicine> findMedicineByIllness(String param);
    String findManufacturerByMedicineName(String param);
    Long findCovidPatientsOnAntibioticsRatio();

    Long findAllCovidPatients();

}
