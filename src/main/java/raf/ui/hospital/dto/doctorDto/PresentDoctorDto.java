package raf.ui.hospital.dto.doctorDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PresentDoctorDto {
    public PresentDoctorDto(){
        listOfSpecializations = new ArrayList<>();
    }
    private String firstName;
    private String lastName;
    private List<String> listOfSpecializations;
    public void addSpecialization(String specialization){
        listOfSpecializations.add(specialization);
    }
}
