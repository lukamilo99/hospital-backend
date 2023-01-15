package raf.ui.hospital.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import raf.ui.hospital.dto.prescriptionDto.CreatePrescriptionDto;
import raf.ui.hospital.dto.prescriptionDto.PresentPrescriptionDto;
import raf.ui.hospital.model.Doctor;
import raf.ui.hospital.model.Medicine;
import raf.ui.hospital.model.Patient;
import raf.ui.hospital.model.Prescription;
import raf.ui.hospital.repository.MedicineRepository;
import raf.ui.hospital.repository.PatientRepository;
import raf.ui.hospital.service.DoctorService;
import raf.ui.hospital.service.MedicineService;
import raf.ui.hospital.service.PatientService;
import java.util.Optional;

@Component
@AllArgsConstructor
public class PrescriptionMapper {
    private MedicineMapper medicineMapper;
    private DoctorService doctorService;
    private PatientService patientService;
    private MedicineService medicineService;
    public PresentPrescriptionDto toDto(Prescription prescription){
        PresentPrescriptionDto dto = new PresentPrescriptionDto();
        String doctorsFullname = prescription.getDoctor().getFirstName() + " " + prescription.getDoctor().getLastName();
        dto.setDoctorsFullName(doctorsFullname);
        String patientFullname = prescription.getPatient().getFirstName() + " " + prescription.getPatient().getLastName();
        dto.setPatientFullName(patientFullname);
        dto.setCreationDate(prescription.getCreateDate());
        dto.setMedicine(medicineMapper.toDto(prescription.getMedicine()));

        return dto;
    }

    public Prescription toPrescription(CreatePrescriptionDto dto){
        Prescription prescription = new Prescription();

        Optional<Doctor> doctor = doctorService.findDoctorEntityById(dto.getDoctorId());
        if (doctor.isPresent()) prescription.setDoctor(doctor.get());
        else System.out.println("There is no doctor with id " + dto.getDoctorId());

        Optional<Patient> patient = patientService.findById(dto.getPatientId());
        if (patient.isPresent()) prescription.setPatient(patient.get());
        else System.out.println("There is no patient with id " + dto.getPatientId());

        Optional<Medicine> medicine = medicineService.findById(dto.getMedicineId());
        if (medicine.isPresent()) prescription.setMedicine(medicine.get());
        else System.out.println("There is no medicine with id " + dto.getMedicineId());

        prescription.setCreateDate(dto.getCreationDate());

        return prescription;
    }
}
