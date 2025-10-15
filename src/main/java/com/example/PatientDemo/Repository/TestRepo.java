package com.example.PatientDemo.Repository;

import com.example.PatientDemo.Entities.PatientDetailsEntity;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface TestRepo {
    List<PatientDetailsEntity> getPatientDetailsById(Long id);
    List<PatientDetailsEntity> getPatientByName(String name);
    List<PatientDetailsEntity> getPatientsByAgeGreaterThan(int age);
    List<PatientDetailsEntity> getPatientsByDisease(String disease);
}