package raf.ui.hospital.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne()
    @JoinColumn(name = "hospital_stay_id", referencedColumnName = "id")
    private HospitalStay hospitalStay;
    @OneToOne
    @JoinColumn(name = "accountant_id", referencedColumnName = "id")
    private Accountant accountant;
    private BigDecimal price;
    private Date creationDate;
}
