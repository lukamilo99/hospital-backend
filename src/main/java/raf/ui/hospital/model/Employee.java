package raf.ui.hospital.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "job")
@Getter
@Setter
@NoArgsConstructor
public abstract class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Date hireDate;
    private boolean isOnVacation;
    private int vacationDays;
    @OneToMany(mappedBy = "employee")
    private List<Overtime> monthlyOvertime;

    @OneToMany(mappedBy = "employee")
    private List<Vacation> yearlyVacation;

}
