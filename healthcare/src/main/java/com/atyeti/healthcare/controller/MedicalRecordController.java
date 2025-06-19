package com.atyeti.healthcare.controller;

import com.atyeti.healthcare.dto.MedicalRecordDTO;
import com.atyeti.healthcare.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medical-records")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService recordService;

    // 1. Add new Medical Record
    @PostMapping
    public MedicalRecordDTO addRecord(@RequestBody MedicalRecordDTO dto) {
        return recordService.addRecord(dto);
    }

    // 2. Get all Medical Records
    @GetMapping
    public List<MedicalRecordDTO> getAllRecords() {
        return recordService.getAllRecords();
    }

    // 3. Get Medical Record by ID
    @GetMapping("/{id}")
    public MedicalRecordDTO getRecordById(@PathVariable Long id) {
        return recordService.getRecordById(id);
    }

    // 4. Get Records by Patient ID
    @GetMapping("/patient/{patientId}")
    public List<MedicalRecordDTO> getRecordsByPatient(@PathVariable Long patientId) {
        return recordService.getRecordsByPatient(patientId);
    }

    // 5. Delete Record by ID
    @DeleteMapping("/{id}")
    public String deleteRecord(@PathVariable Long id) {
        recordService.deleteRecord(id);
        return "Medical record deleted successfully";
    }
}
