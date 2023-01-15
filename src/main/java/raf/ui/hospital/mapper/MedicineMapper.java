package raf.ui.hospital.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import raf.ui.hospital.dto.medicineDto.CreateMedicineDto;
import raf.ui.hospital.dto.medicineDto.PresentMedicineDto;
import raf.ui.hospital.model.Illness;
import raf.ui.hospital.model.Medicine;
import raf.ui.hospital.service.IllnessService;

import java.util.Optional;

@Component
@AllArgsConstructor
public class MedicineMapper {
    private IllnessService illnessService;
    public PresentMedicineDto toDto (Medicine medicine){
        PresentMedicineDto presentMedicineDto = new PresentMedicineDto();
        presentMedicineDto.setManufacturer(medicine.getManufacturer());
        presentMedicineDto.setName(medicine.getName());
        presentMedicineDto.setSize(medicine.getSize());
        presentMedicineDto.setType(medicine.getType());
        return presentMedicineDto;
    }

    public Medicine toMedicine(CreateMedicineDto dto){
        Medicine medicine = new Medicine();
        medicine.setSize(dto.getSize());
        medicine.setName(dto.getName());
        medicine.setManufacturer(dto.getManufacturer());
        medicine.setName(dto.getName());

        for(String illnessName: dto.getListOfIllness()){
            Optional<Illness> illness = illnessService.findByName(illnessName);
            if(illness.isPresent()) medicine.addIllness(illness.get());
            else System.out.println("There is no illness with name " + illnessName);
        }

        return medicine;
    }
}
