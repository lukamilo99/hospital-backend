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
public class Doctor extends Employee{
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "specialization_id")
    )
    private List<Specialization> specializationList;
    @ManyToMany(mappedBy = "doctorList")
    private List<Operation> operationList;
    @OneToMany(mappedBy = "doctor")
    private List<Prescription> prescriptionList;
    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointmentList;
    @OneToMany(mappedBy = "doctor")
    private List<PatientDoctor> personalPatientList;
    @OneToMany(mappedBy = "releaseDoctor")
    private List<HospitalStay> releaseList;
    @OneToMany(mappedBy = "doctor")
    private List<NightshiftDoctor> nightshiftList;
    @OneToMany(mappedBy = "doctor")
    private List<DoctorDepartment> departmentList;
    @OneToMany(mappedBy = "doctor")
    private List<ProcedureLicence> licenceList;
}
