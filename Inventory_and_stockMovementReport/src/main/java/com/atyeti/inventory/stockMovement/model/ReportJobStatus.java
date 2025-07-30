package com.atyeti.inventory.stockMovement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "report_job_status")
public class ReportJobStatus {
    @Id
    private String jobId;

    private String status;
    private long totalRows;
    private long processedRows;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(long totalRows) {
        this.totalRows = totalRows;
    }

    public long getProcessedRows() {
        return processedRows;
    }

    public void setProcessedRows(long processedRows) {
        this.processedRows = processedRows;
    }
}
