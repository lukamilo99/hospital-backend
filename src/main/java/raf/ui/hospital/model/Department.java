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
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Block block;
    @OneToMany(mappedBy = "department")
    private List<NightshiftDoctor> nightshiftList;
    @OneToMany(mappedBy = "department")
    private List<DoctorDepartment> doctorList;
    private String name;
}
