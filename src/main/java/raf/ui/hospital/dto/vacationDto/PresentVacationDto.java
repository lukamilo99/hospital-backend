package raf.ui.hospital.dto.vacationDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
@NoArgsConstructor
public class PresentVacationDto {
    private Long doctorId;
    private Date startDate;
    private Date endDate;
}
