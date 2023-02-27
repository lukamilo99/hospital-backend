package raf.ui.hospital.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.print.Doc;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class NightshiftDoctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Department department;
    private Date startDate;
    private Date endDate;
}
