package com.atyeti.healthcare.service;

import com.atyeti.healthcare.dto.AppointmentDTO;
import com.atyeti.healthcare.dto.DoctorDTO;
import com.atyeti.healthcare.dto.PatientDTO;

import java.util.List;

public interface AdminService {
    List<DoctorDTO> getAllDoctors();
    List<PatientDTO> getAllPatients();
    List<AppointmentDTO> getAllAppointments();
}
