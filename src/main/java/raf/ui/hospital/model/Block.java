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
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "block")
    private List<Room> roomList;
    @OneToMany(mappedBy = "block")
    private List<NightshiftNurse> nightshiftList;
    @OneToMany(mappedBy = "block")
    private List<Department> department;

    private String name;

    private String numberOfFloors;
}
