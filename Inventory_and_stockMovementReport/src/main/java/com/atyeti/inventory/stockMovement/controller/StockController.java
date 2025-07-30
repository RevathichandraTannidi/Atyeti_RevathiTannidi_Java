package com.atyeti.inventory.stockMovement.controller;

import com.atyeti.inventory.stockMovement.dto.response.CsvProcessingSummary;
import com.atyeti.inventory.stockMovement.service.CsvProcessingService;
import com.atyeti.inventory.stockMovement.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/reports")
public class StockController {

    private final CsvProcessingService csvService;
    private final ReportService reportService;

    @Autowired
    public StockController(CsvProcessingService csvService, ReportService reportService) {
        this.csvService = csvService;
        this.reportService = reportService;
    }

    /** Uploads CSV file and starts async processing. */
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public CsvProcessingSummary uploadCsv(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("Uploaded file is empty");
        }
        return csvService.startJob(file);
    }

    /** Retrieves the processing status for a job id. */
    @GetMapping("/status/{jobId}")
    public CsvProcessingSummary getStatus(@PathVariable String jobId) {
        return csvService.getStatus(jobId);
    }

    @GetMapping("/report/{jobId}")
    public ResponseEntity<Resource> downloadReport(@PathVariable String jobId) throws IOException {
        Resource report = (Resource) reportService.getReportFile(jobId);

        String filename = report.getFilename();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(report);
    }
}
