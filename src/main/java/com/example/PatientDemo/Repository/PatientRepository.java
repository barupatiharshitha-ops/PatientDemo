
package com.example.PatientDemo.Repository;

import com.example.PatientDemo.Entities.PatientDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientDetailsEntity, Long>, TestRepo {
    // No extra code needed here
}
