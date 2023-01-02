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
public class Chief {

    @EmbeddedId
    private ChiefId id;
    @ManyToOne
    @MapsId("doctorId")
    private Doctor doctor;
    @ManyToOne
    @MapsId("departmentId")
    private Department department;

    private Date startDate;

    private Date endDate;
}
