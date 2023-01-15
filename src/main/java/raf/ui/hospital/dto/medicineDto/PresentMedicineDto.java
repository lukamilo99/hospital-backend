package raf.ui.hospital.dto.medicineDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PresentMedicineDto {
    private String name;
    private String type;
    private String manufacturer;
    private String size;
}
