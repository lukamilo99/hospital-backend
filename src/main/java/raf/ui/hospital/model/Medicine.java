package raf.ui.hospital.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String manufacturer;
    private String size;
    @OneToMany(mappedBy = "medicine")
    private List<Prescription> prescriptionList;
    @ManyToMany(mappedBy = "medicineList")
    private List<Illness> illnessList;
}
