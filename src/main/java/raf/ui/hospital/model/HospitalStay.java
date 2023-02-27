package raf.ui.hospital.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class HospitalStay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "hospitalStay")
    private List<Operation> operationList;
    @ManyToOne
    private Doctor releaseDoctor;
    @ManyToOne
    private Patient patient;
    private Date startDate;
    private Date endDate;
    @OneToOne(mappedBy = "hospitalStay")
    private Bill bill;

    @PrePersist
    protected void onCreate() {
        long milis = System.currentTimeMillis();
        startDate = new Date(milis);
    }
}
