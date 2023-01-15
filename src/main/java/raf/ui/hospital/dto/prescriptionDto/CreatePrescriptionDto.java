package raf.ui.hospital.dto.prescriptionDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
@NoArgsConstructor
public class CreatePrescriptionDto {
    private Long doctorId;
    private Long patientId;
    private Long medicineId;
    private Date creationDate;
}
