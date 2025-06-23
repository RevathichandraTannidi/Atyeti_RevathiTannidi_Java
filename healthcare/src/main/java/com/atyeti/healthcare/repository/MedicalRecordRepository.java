package com.atyeti.healthcare.repository;

import com.atyeti.healthcare.model.MedicalRecord;
import com.atyeti.healthcare.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
      List<MedicalRecord> findByPatientId(Long patientId);

}
