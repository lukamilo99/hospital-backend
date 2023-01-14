package raf.ui.hospital.repository;

import raf.ui.hospital.model.Medicine;
import raf.ui.hospital.model.Procedure;

import java.util.List;
public interface CustomRepository {

    List<Medicine> findMedicineByIllness(String param);
    String findManufacturerByMedicineName(String param);
    Long findCovidPatientsOnAntibioticsRatio();
    List<String[]> findNumberOfProceduresGroupBySpecialization();
    String findDepartmentWithMostProcedures();
    List<Procedure> findProceduresOrderByPrice();
    Double findDoctorsWeeklyProcedureNumber(String firstName, String lastName);

}
