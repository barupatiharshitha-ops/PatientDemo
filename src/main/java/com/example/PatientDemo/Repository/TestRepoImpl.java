package com.example.PatientDemo.Repository;

import com.example.PatientDemo.Entities.PatientDetailsEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestRepoImpl implements TestRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PatientDetailsEntity> getPatientDetailsById(Long id) {
        TypedQuery<PatientDetailsEntity> query = entityManager.createQuery("select p from PatientDetailsEntity p where p.id = :id", PatientDetailsEntity.class);
        query.setParameter("id",id);
        return query.getResultList();
    }

    @Override
    public List<PatientDetailsEntity> getPatientByName(String name) {
        TypedQuery<PatientDetailsEntity> query = entityManager.createQuery("select p from PatientDetailsEntity p where p.name = :name", PatientDetailsEntity.class);
        query.setParameter("name",name);
        return query.getResultList();
    }

    @Override
    public List<PatientDetailsEntity> getPatientsByAgeGreaterThan(int age) {
        TypedQuery<PatientDetailsEntity> query = entityManager.createQuery("select p from PatientDetailsEntity p where p.age > :age" , PatientDetailsEntity.class);
        query.setParameter("age" , age);
        return query.getResultList();
    }

    @Override
    public List<PatientDetailsEntity> getPatientsByDisease(String disease) {
        TypedQuery<PatientDetailsEntity> query = entityManager.createQuery("select p from PatientDetailsEntity p where p.disease = :disease" , PatientDetailsEntity.class);
        query.setParameter("disease" , disease);
        return query.getResultList();
    }
}
