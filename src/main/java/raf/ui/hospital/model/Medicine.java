package raf.ui.hospital.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Medicine {
    public Medicine(){
        illnessList = new ArrayList<>();
    }
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

    public void addIllness(Illness illness){
        illnessList.add(illness);
    }
}
