package com.atyeti.inventory.stockMovement.util;

import com.atyeti.inventory.stockMovement.model.ReportJobStatus;
import com.atyeti.inventory.stockMovement.repository.ReportJobStatusRepository;
import org.springframework.web.multipart.MultipartFile;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.function.Consumer;

public class CsvParserUtil {

    public static void streamCsv(MultipartFile file,
                                 Consumer<CSVRecord> recordConsumer,
                                 ReportJobStatusRepository statusRepo,
                                 String jobId) {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
             CSVParser parser = CSVParser.parse(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withTrim())) {

            for (CSVRecord record : parser) {
                recordConsumer.accept(record);

                ReportJobStatus status = statusRepo.findById(jobId).orElseThrow();
                status.setProcessedRows(status.getProcessedRows() + 1);
                statusRepo.save(status);
            }

            ReportJobStatus finalStatus = statusRepo.findById(jobId).orElseThrow();
            finalStatus.setStatus("COMPLETED");
            statusRepo.save(finalStatus);

        } catch (Exception ex) {
            ReportJobStatus status = statusRepo.findById(jobId).orElseThrow();
            status.setStatus("FAILED");
            statusRepo.save(status);
            throw new RuntimeException("CSV parsing failed", ex);
        }
    }
}
