package raf.ui.hospital.service;

import raf.ui.hospital.dto.MedicineDto;

import java.util.List;

public interface CustomService {

    List<MedicineDto> query1(String param);
    String query2(String param);
    Long query3();
}
