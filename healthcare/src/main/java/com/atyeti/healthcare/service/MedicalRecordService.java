package com.atyeti.healthcare.service;

import com.atyeti.healthcare.dto.MedicalRecordDTO;

import java.util.List;

public interface MedicalRecordService {

    MedicalRecordDTO addRecord(MedicalRecordDTO dto);

    List<MedicalRecordDTO> getRecordsByPatient(Long patientId);

    // New methods:
    List<MedicalRecordDTO> getAllRecords();

    MedicalRecordDTO getRecordById(Long id);

    void deleteRecord(Long id);
}
