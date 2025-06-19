package com.atyeti.healthcare.repository;



import com.atyeti.healthcare.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    // Add custom query methods if needed
}
