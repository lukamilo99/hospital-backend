package raf.ui.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MedicineDto {
    private String name;
    private String type;
    private String manufacturer;
    private String size;
}
