package com.atyeti.inventory.stockMovement.service;


import com.atyeti.inventory.stockMovement.dto.response.CsvProcessingSummary;
import com.atyeti.inventory.stockMovement.exception.ResourceNotFoundException;
import com.atyeti.inventory.stockMovement.model.ReportJobStatus;
import com.atyeti.inventory.stockMovement.repository.*;
import com.atyeti.inventory.stockMovement.util.CsvParserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class CsvProcessingService {

    private final ReportJobStatusRepository statusRepo;

    @Autowired
    public CsvProcessingService(ReportJobStatusRepository statusRepo) {
        this.statusRepo = statusRepo;
    }

    @Async
    public CsvProcessingSummary startJob(MultipartFile file) {
        String jobId = UUID.randomUUID().toString();
        ReportJobStatus status = new ReportJobStatus();
        status.setJobId(jobId);
        status.setStatus("IN_PROGRESS");
        status.setTotalRows(0);
        status.setProcessedRows(0);
        statusRepo.save(status);

        CsvParserUtil.streamCsv(file, record -> {

            status.setProcessedRows(status.getProcessedRows() + 1);
            statusRepo.save(status);
        }, statusRepo, jobId);

        return new CsvProcessingSummary(jobId, status.getTotalRows(), status.getProcessedRows(), status.getStatus());
    }

    public CsvProcessingSummary getStatus(String jobId) {
        ReportJobStatus status = statusRepo.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("Job status", jobId));
        return new CsvProcessingSummary(jobId, status.getTotalRows(), status.getProcessedRows(), status.getStatus());
    }
}
