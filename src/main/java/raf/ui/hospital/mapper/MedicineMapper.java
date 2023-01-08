package raf.ui.hospital.mapper;

import org.springframework.stereotype.Component;
import raf.ui.hospital.dto.MedicineDto;
import raf.ui.hospital.model.Medicine;

@Component
public class MedicineMapper {
    public MedicineDto toDto (Medicine medicine){
        MedicineDto medicineDto = new MedicineDto();
        medicineDto.setManufacturer(medicine.getManufacturer());
        medicineDto.setName(medicine.getName());
        medicineDto.setSize(medicine.getSize());
        medicineDto.setType(medicine.getType());
        return medicineDto;
    }
}
