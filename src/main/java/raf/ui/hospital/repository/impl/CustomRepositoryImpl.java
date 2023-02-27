package raf.ui.hospital.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.stereotype.Repository;
import raf.ui.hospital.repository.CustomRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomRepositoryImpl implements CustomRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<String[]> findMedicineByIllness(String illnessName) {
        String jpql = "SELECT m.name, count(m.id) FROM Prescription p JOIN Medicine m ON (p.medicine.id = m.id) JOIN m.illnessList il JOIN Illness i ON (il.id = i.id)" +
                " WHERE i.name =: illnessName GROUP BY m.name ORDER BY count(m.id) desc";
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
        String jpql = "SELECT m.manufacturer FROM Prescription p JOIN Medicine m ON (p.medicine.id = m.id) WHERE m.name = :medicineName" +
                " GROUP BY m.manufacturer order by count(m.id) desc LIMIT 1";
        TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
        query.setParameter("medicineName", param);

        return query.getSingleResult();
    }

    @Override
    public Long findCovidPatientsOnAntibioticsRatio() {
        String jpql = "SELECT count(distinct(p.patient.id)) FROM Prescription p WHERE p.patient.id IN (SELECT pa.id FROM Patient pa JOIN Prescription pr ON (pa.id = pr.patient.id)" +
                " WHERE pr.createDate BETWEEN pa.covidFromDate AND pa.covidToDate) AND p.medicine.id IN (SELECT m.id FROM Medicine m WHERE m.type = 'Antibiotic')";
        TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);

        Long covidPatientsOnAntibiotics = query.getSingleResult();
        Long allCovidPatients = findAllCovidPatients();

        return (covidPatientsOnAntibiotics * 100 / allCovidPatients);
    }

    private Long findAllCovidPatients() {
        String jpql = "SELECT count(p.id) FROM Patient p WHERE p.covidFromDate IS NOT NULL";
        TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);

        return query.getSingleResult();
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
        String jpql = "SELECT de.department.name FROM Department d JOIN Doctor do JOIN do.operationList ol JOIN DoctorDepartment de ON (do.id = de.doctor.id)" +
                " GROUP BY de.department.id ORDER BY count(ol.id) desc LIMIT 1";
        TypedQuery<String> query = entityManager.createQuery(jpql, String.class);

        return query.getSingleResult();
    }

    @Override
    public Double findDoctorsWeeklyProcedureNumber(String firstName, String lastName) {
        String jpql = "SELECT count(ol.id) FROM Doctor d JOIN d.operationList ol WHERE d.firstName =: firstName AND d.lastName =: lastName";
        TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);

        Double numOfProc = Double.valueOf(query.getSingleResult());
        Double numOfWeeks = Double.valueOf(findDoctorsWorkingWeeks(firstName, lastName));

        return numOfProc / numOfWeeks;
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
    public List<String> findProceduresOrderByPrice() {
        String jpql = "SELECT p.name FROM Procedure p ORDER BY p.price desc";
        TypedQuery<String> query = entityManager.createQuery(jpql, String.class);

        return query.getResultList();
    }
}

