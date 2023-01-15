package raf.ui.hospital.dto.prescriptionDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import raf.ui.hospital.dto.medicineDto.PresentMedicineDto;
import java.sql.Date;
@Getter
@Setter
@NoArgsConstructor
public class PresentPrescriptionDto {
    private String doctorsFullName;
    private String patientFullName;
    private PresentMedicineDto medicine;
    private Date creationDate;
}
