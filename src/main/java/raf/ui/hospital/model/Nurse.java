package raf.ui.hospital.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Nurse extends Employee {
    private boolean licence;
    @OneToMany(mappedBy = "nurse")
    private List<Appointment> appointmentList;
    @ManyToMany(mappedBy = "nurseList")
    private List<Operation> operationList;

    @OneToMany(mappedBy = "nurse")
    private List<NightshiftNurse> nightshiftList;
}
