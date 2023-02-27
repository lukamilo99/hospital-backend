package raf.ui.hospital.repository;

import java.util.List;
public interface CustomRepository {

    List<String[]> findMedicineByIllness(String param);
    String findManufacturerByMedicineName(String param);
    Long findCovidPatientsOnAntibioticsRatio();
    List<String[]> findNumberOfProceduresGroupBySpecialization();
    String findDepartmentWithMostProcedures();
    List<String> findProceduresOrderByPrice();
    Double findDoctorsWeeklyProcedureNumber(String firstName, String lastName);
}
