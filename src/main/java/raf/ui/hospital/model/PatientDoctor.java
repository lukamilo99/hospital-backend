package raf.ui.hospital.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PatientDoctor {
    @EmbeddedId
    private PatientDoctorId id;

    @ManyToOne
    @MapsId("studentId")
    private Patient patient;
    @ManyToOne
    @MapsId("doctorId")
    private Doctor doctor;

    private Date fromDate;
    private Date toDate;

}
