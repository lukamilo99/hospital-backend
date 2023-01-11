package raf.ui.hospital.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import raf.ui.hospital.model.Medicine;
import raf.ui.hospital.repository.CustomRepository;
import java.util.List;
@Repository
public class CustomRepositoryImpl implements CustomRepository {
    @PersistenceContext
    EntityManager entityManager;

    //Koji su najčešći lekovi koji se prepisuju pacijentu sa određenom dijagnozom.
    //select name, manufacturer, count(medicine_id) total from prescription p join medicine m on (m.id = p.medicine_id) where medicine_id in
    // (select medicine_id from illness_medicine_list im join illness i on (im.medicine_id = i.id) where i.name = 'Asthma') group by medicine_id order by total desc;

    //Da se napravi analiza za “ime_leka” od kog proizvođača se najčešće prepisuje
    //select manufacturer, count(medicine_id) total from prescription p join medicine m on (p.medicine_id = m.id) where name = 'Xanax' group by manufacturer order by total desc limit 1;

    //Koliko procentualno osoba sa dijagnozom covid-a je tokom svoje terapije dobijalo neki antibiotik?
    //select count(distinct(patient_id)) from prescription where patient_id in (select patient_id from patient pa join prescription pr on (pa.id = pr.patient_id) where pr.create_date between pa.covid_from_date and pa.covid_to_date) and medicine_id in (select id from medicine where type = 'Antibiotic');
    @Override
    public List<Medicine> findMedicineByIllness(String illness) {
        String jpql = "SELECT p.medicine FROM Prescription p JOIN Medicine m ON (p.medicine.id = m.id) WHERE p.medicine.id IN (SELECT m.id FROM Medicine m JOIN m.illnessList il WHERE il.name = :illnessName) GROUP BY p.medicine.id";
        TypedQuery<Medicine> query = entityManager.createQuery(jpql, Medicine.class);
        query.setParameter("illnessName", illness);
        return query.getResultList();
    }

    @Override
    public String findManufacturerByMedicineName(String param) {
        String jpql = "SELECT m.manufacturer FROM Prescription p JOIN Medicine m ON (p.medicine.id = m.id) WHERE m.name = :medicineName GROUP BY m.manufacturer order by count(m.id) desc LIMIT 1";
        TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
        query.setParameter("medicineName", param);
        return query.getSingleResult();
    }

    @Override
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

}

