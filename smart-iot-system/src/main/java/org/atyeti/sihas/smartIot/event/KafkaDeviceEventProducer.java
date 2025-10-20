package org.atyeti.sihas.smartIot.event;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaDeviceEventProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "device-commands";

    public void sendCommand(String deviceId, String command) {
        String payload = deviceId + ":" + command;
        kafkaTemplate.send(TOPIC, deviceId, payload);
    }
}
