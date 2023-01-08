package raf.ui.hospital.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import raf.ui.hospital.model.Medicine;
import raf.ui.hospital.repository.CustomRepository;
import java.util.List;
@Repository
public class QueryOneRepository implements CustomRepository {
    @PersistenceContext
    EntityManager entityManager;

    //Koji su najčešći lekovi koji se prepisuju pacijentu sa određenom dijagnozom.
    //select name, manufacturer, count(medicine_id) total from prescription p join medicine m on (m.id = p.medicine_id) where medicine_id in
    // (select medicine_id from illness_medicine_list im join illness i on (im.medicine_id = i.id) where i.name = 'Asthma') group by medicine_id order by total desc;

    @Override
    public List<Medicine> findByIllnessList(String param) {
        String jpql = "SELECT p.medicine, count(p.medicine.id) FROM Prescription p JOIN Medicine m ON (p.medicine.id = m.id) WHERE p.medicine.id IN (SELECT m.id FROM Medicine m JOIN m.illnessList il WHERE il.name = :illnessName) GROUP BY p.medicine.id";
        TypedQuery<Medicine> query = entityManager.createQuery(jpql, Medicine.class);
        query.setParameter("illnessName", param);

        return query.getResultList();
    }

    @Override
    public List<Medicine> findByName(String param) {
        String jpql = "SELECT p.medicine FROM Prescription p JOIN Medicine m ON (p.medicine.id = m.id) WHERE p.medicine.name = :medicineName GROUP BY p.medicine.manufacturer order by count(p.medicine.id)";
        TypedQuery<Medicine> query = entityManager.createQuery(jpql, Medicine.class);
        query.setParameter("medicineName", param);

        return query.getResultList();
    }

    //Da se napravi analiza za “ime_leka” od kog proizvođača se najčešće prepisuje
    //select manufacturer, count(medicine_id) total from prescription p join medicine m on (p.medicine_id = m.id) where name = 'Xanax' group by manufacturer order by total desc;
}
