package com.atyeti.inventory.stockMovement.repository;

import com.atyeti.inventory.stockMovement.model.ReportJobStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportJobStatusRepository extends JpaRepository<ReportJobStatus, String> {

}

