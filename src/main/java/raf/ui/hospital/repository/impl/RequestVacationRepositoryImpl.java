package raf.ui.hospital.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import raf.ui.hospital.dto.vacationDto.CreateVacationDto;
import raf.ui.hospital.repository.RequestVacationRepository;
import java.sql.Date;
import java.util.List;

@Repository
public class RequestVacationRepositoryImpl implements RequestVacationRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public boolean requestVacation(CreateVacationDto dto) {
        Long doctorId = dto.getDoctorId();
        Date startDate = dto.getStartDate();

        String jpql = "SELECT count(v.id), count(distinct(dd.doctor.id)) FROM Vacation v JOIN DoctorDepartment dd ON (v.employee.id = dd.doctor.id)" +
                " WHERE dd.department.id IN (SELECT dd.department.id FROM DoctorDepartment dd WHERE dd.doctor.id =: doctorId) " +
                "AND v.fromDate <: startDate AND v.toDate >: startDate GROUP BY dd.department.id";
        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        query.setParameter("doctorId", doctorId);
        query.setParameter("startDate", startDate);

        List<Object[]> vacationEmployeeRatioList = query.getResultList();

        for(Object[] ratio: vacationEmployeeRatioList){
            Long numOfVacations = castLong(ratio[0]);
            Long numOfDoctors = castLong(ratio[1]);

            if(numOfVacations * 100 / numOfDoctors > 15) return false;
            else return true;
        }
        return true;
    }

    private Long castLong(Object o) {
        Long value = null;
        if (o != null) {
            value = Long.parseLong(o.toString());
        }
        return value;
    }
}

