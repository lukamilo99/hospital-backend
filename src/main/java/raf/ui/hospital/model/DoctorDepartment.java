package raf.ui.hospital.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DoctorDepartment {

    @EmbeddedId
    private DoctorDepartmentId id;
    @ManyToOne
    @MapsId("doctorId")
    private Doctor doctor;
    @ManyToOne
    @MapsId("departmentId")
    private Department department;

    private boolean primaryDepartment;
}
