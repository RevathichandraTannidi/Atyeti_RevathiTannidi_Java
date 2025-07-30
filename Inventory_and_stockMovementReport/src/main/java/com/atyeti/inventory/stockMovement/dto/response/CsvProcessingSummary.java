package com.atyeti.inventory.stockMovement.dto.response;

public class CsvProcessingSummary {
    private String jobId;
    private long totalRows;
    private long processedRows;
    private String status;

    public CsvProcessingSummary() {}
    public CsvProcessingSummary(String jobId, long totalRows, long processedRows, String status) {
        this.jobId = jobId;
        this.totalRows = totalRows;
        this.processedRows = processedRows;
        this.status = status;
    }

    public String getJobId() { return jobId; }
    public long getTotalRows() { return totalRows; }
    public long getProcessedRows() { return processedRows; }
    public String getStatus() { return status; }
    public void setJobId(String jobId) { this.jobId = jobId; }
    public void setTotalRows(long totalRows) { this.totalRows = totalRows; }
    public void setProcessedRows(long processedRows) { this.processedRows = processedRows; }
    public void setStatus(String status) { this.status = status; }
}
