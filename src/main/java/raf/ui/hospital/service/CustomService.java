package raf.ui.hospital.service;

import raf.ui.hospital.dto.MedicineDto;
import raf.ui.hospital.model.Medicine;
import java.util.List;

public interface CustomService {

    List<MedicineDto> query1(String param);
    List<MedicineDto> query2(String param);
}
