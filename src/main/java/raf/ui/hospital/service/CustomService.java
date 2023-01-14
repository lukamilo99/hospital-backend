package raf.ui.hospital.service;

import raf.ui.hospital.dto.MedicineDto;
import raf.ui.hospital.dto.ProcedureDto;

import java.util.List;

public interface CustomService {

    List<MedicineDto> query1(String param);
    String query2(String param);
    Long query3();
    List<String[]> query4();
    String query5();
    List<ProcedureDto> query6();
    Double query7(String firstName, String lastName);
}
