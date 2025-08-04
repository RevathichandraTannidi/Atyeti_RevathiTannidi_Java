package com.example.inventory.repositories;

import com.example.inventory.model.ReportJobStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportJobStatusRepository extends JpaRepository<ReportJobStatus, Long> {
}
