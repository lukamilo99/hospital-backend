package raf.ui.hospital.dto.doctorDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateDoctorDto {
    private String firstName;
    private String lastName;
    private List<String> listOfSpecializations;
}
