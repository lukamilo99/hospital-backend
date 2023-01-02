package raf.ui.hospital.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

@Entity
@Table(name = "procedures")
@Getter
@Setter
@NoArgsConstructor
public class Procedure {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    @OneToMany(mappedBy = "procedure")
    private List<ProcedureLicence> procedureLicences;
    @OneToMany(mappedBy = "procedure")
    private List<Operation> operationList;
}
