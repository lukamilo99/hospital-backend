package raf.ui.hospital.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
@Embeddable
@Data
public class DoctorDepartmentId implements Serializable {

    @Column(name = "doctor_id")
    private Long doctorId;

    @Column(name = "department_id")
    private Long departmentId;
}
