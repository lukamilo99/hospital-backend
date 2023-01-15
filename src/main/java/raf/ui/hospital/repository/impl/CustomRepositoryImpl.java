package raf.ui.hospital.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.stereotype.Repository;
import raf.ui.hospital.model.Medicine;
import raf.ui.hospital.model.Procedure;
import raf.ui.hospital.repository.CustomRepository;

import java.sql.Date;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomRepositoryImpl implements CustomRepository {
    @PersistenceContext
    EntityManager entityManager;

    //Koji su najčešći lekovi koji se prepisuju pacijentu sa određenom dijagnozom.
    //select count(m.id) total, m.name from prescription p join illness_medicine_list im on (p.medicine_id = im.medicine_id) join illness i on (im.ilness_id = i.id) join medicine m on (p.medicine_id = m.id)
    // where i.name = 'Asthma' group by m.name order by total desc;

    //Da se napravi analiza za “ime_leka” od kog proizvođača se najčešće prepisuje
    //select manufacturer, count(medicine_id) total from prescription p join medicine m on (p.medicine_id = m.id) where name = 'Xanax' group by manufacturer order by total desc limit 1;

    //Koliko procentualno osoba sa dijagnozom covid-a je tokom svoje terapije dobijalo neki antibiotik?
    //select count(distinct(patient_id)) from prescription where patient_id in (select patient_id from patient pa join prescription pr on (pa.id = pr.patient_id) where pr.create_date between pa.covid_from_date and pa.covid_to_date) and medicine_id in (select id from medicine where type = 'Antibiotic');

    //Po specijalizacijama grupisati koliko u proseku imaju (srednja vrednost) licenci za
    //procedure.

    //Prikaz svih procedura, koje se vrše u bolnici, sortiranih opadajuće po ceni.
    //select * from procedures order by price desc;

    //Koje odeljenje je imalo najviše procedura(meni operacija).
    //select count(operation_id) total, department_id from operation_doctor_list ol join doctor_department dp on (ol.doctor_id = dp.doctor_id) group by department_id order by total desc;

    //Koliko prosečno procedura izvrši neki lekar nedeljno.
    //select count(operation_id) from operation_doctor_list od join employee d on (od.doctor_id = d.id) where d.first_name = 'Marko' and d.last_name = 'Ilic';
    //select truncate(datediff(sysdate(), hire_date) / 7, 0) from employee;

    @Override
    public List<String[]> findMedicineByIllness(String illnessName) {
        String jpql = "SELECT m.name, count(m.id) FROM Prescription p JOIN Medicine m ON (p.medicine.id = m.id) JOIN m.illnessList il JOIN Illness i ON (il.id = i.id) WHERE i.name =: illnessName GROUP BY m.name ORDER BY count(m.id) desc";
        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        query.setParameter("illnessName", illnessName);
        List<String[]> resultList = new ArrayList<>();

        for(Object[] objList: query.getResultList()){
            resultList.add(new String[]{objList[0].toString(), objList[1].toString()});
        }

        return resultList;
    }

    @Override
    public String findManufacturerByMedicineName(String param) {
        String jpql = "SELECT m.manufacturer FROM Prescription p JOIN Medicine m ON (p.medicine.id = m.id) WHERE m.name = :medicineName GROUP BY m.manufacturer order by count(m.id) desc LIMIT 1";
        TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
        query.setParameter("medicineName", param);

        return query.getSingleResult();
    }
    public Long findAllCovidPatients() {
        String jpql = "SELECT count(p.id) FROM Patient p WHERE p.covidFromDate IS NOT NULL";
        TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);

        return query.getSingleResult();
    }
    @Override
    public Long findCovidPatientsOnAntibioticsRatio() {
        String jpql = "SELECT count(distinct(p.patient.id)) FROM Prescription p WHERE p.patient.id IN (SELECT pa.id FROM Patient pa JOIN Prescription pr ON (pa.id = pr.patient.id) WHERE pr.createDate BETWEEN pa.covidFromDate AND pa.covidToDate) AND p.medicine.id IN (SELECT m.id FROM Medicine m WHERE m.type = 'Antibiotic')";
        TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
        Long allCovidPatients = findAllCovidPatients();
        Long covidPatientsOnAntibiotics = query.getSingleResult();

        return (covidPatientsOnAntibiotics * 100 / allCovidPatients);
    }
    public List<Long> findNumberOfDoctorBySpecialization(){
        String jpql = "SELECT count(d.id) FROM Doctor d JOIN d.specializationList sl GROUP BY sl.id ORDER BY sl.id asc";
        TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);

        return query.getResultList();
    }
    @Override
    public List<String[]> findNumberOfProceduresGroupBySpecialization() {
        String jpql = "SELECT count(pl.id), sl.name FROM ProcedureLicence pl JOIN Doctor d ON (pl.doctor.id = d.id) JOIN d.specializationList sl GROUP BY sl.id ORDER BY sl.id asc";
        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        List<String[]> resultList = new ArrayList<>();

        for(Object[] objList: query.getResultList()){
            resultList.add(new String[]{objList[0].toString(), objList[1].toString()});
        }
        return resultList;
    }
    @Override
    public String findDepartmentWithMostProcedures() {
        String jpql = "SELECT de.department.name FROM Department d JOIN Doctor do JOIN do.operationList ol JOIN DoctorDepartment de ON (do.id = de.doctor.id) GROUP BY de.department.id ORDER BY count(ol.id) desc LIMIT 1";
        TypedQuery<String> query = entityManager.createQuery(jpql, String.class);

        return query.getSingleResult();
    }

    private int findDoctorsWorkingWeeks(String firstName, String lastName){
        String jpql = "SELECT d.hireDate from Doctor d WHERE d.firstName =: firstName AND d.lastName =: lastName";
        TypedQuery<Date> query = entityManager.createQuery(jpql, Date.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        Date startDate = query.getSingleResult();
        Date currentDate = Date.valueOf(java.time.LocalDate.now());

        return Days.daysBetween(new DateTime(startDate), new DateTime(currentDate)).getDays() / 7;
    }

    @Override
    public Double findDoctorsWeeklyProcedureNumber(String firstName, String lastName) {
        String jpql = "SELECT count(ol.id) FROM Doctor d JOIN d.operationList ol WHERE d.firstName =: firstName AND d.lastName =: lastName";
        TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        Double numOfProc = Double.valueOf(query.getSingleResult());
        Double numOfWeeks = Double.valueOf(findDoctorsWorkingWeeks(firstName, lastName));

        // broj ce biti mnogo mali zato sto doktor ima 4 operacije, a radio je 159 nedelja
        return numOfProc / numOfWeeks;
    }

    @Override
    public List<Procedure> findProceduresOrderByPrice() {
        String jpql = "SELECT p FROM Procedure p ORDER BY p.price desc";
        TypedQuery<Procedure> query = entityManager.createQuery(jpql, Procedure.class);

        return query.getResultList();
    }
}

