package org.atyeti.sihas.smartIot.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.atyeti.sihas.smartIot.entity.DeviceLog;
import org.atyeti.sihas.smartIot.repository.DeviceLogRepository;
import org.atyeti.sihas.smartIot.service.DeviceService;
import org.atyeti.sihas.smartIot.websocket.WebSocketService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaDeviceEventConsumer {

    private final WebSocketService wsService;
    private final DeviceService deviceService;
    private final DeviceLogRepository logRepo;

    @KafkaListener(topics = "device-status", groupId = "sihas-group")
    public void onDeviceStatus(String message) {
        log.info("Received Kafka message on 'device-status': {}", message);

        try {
            String[] parts = message.split(":", 2);
            String deviceId = parts[0];
            String payload = parts.length > 1 ? parts[1] : "UNKNOWN";

            DeviceLog logEntry = DeviceLog.builder()
                    .deviceId(deviceId)
                    .payload(payload)
                    .ts(LocalDateTime.now())
                    .build();

            logRepo.save(logEntry);
            deviceService.updateStatusFromEvent(deviceId, payload);
            wsService.sendDeviceUpdate(deviceId, payload);

        } catch (Exception e) {
            log.error("Error processing Kafka message", e);
        }
    }
}
