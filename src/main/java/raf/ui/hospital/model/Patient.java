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
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @OneToMany(mappedBy = "patient")
    private List<Diagnosis> diagnosisList;
    @OneToMany(mappedBy = "patient")
    private List<Prescription> prescriptionList;
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointmentList;
    @OneToMany(mappedBy = "patient")
    private List<PatientDoctor> personalDoctorList;
    @OneToMany(mappedBy = "patient")
    private List<Operation> operationList;
    @OneToMany(mappedBy = "patient")
    private List<HospitalStay> hospitalStayList;

}
