package raf.ui.hospital.dto.medicineDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CreateMedicineDto {
    private String name;
    private String type;
    private String manufacturer;
    private String size;
    private List<String> listOfIllness;
}
