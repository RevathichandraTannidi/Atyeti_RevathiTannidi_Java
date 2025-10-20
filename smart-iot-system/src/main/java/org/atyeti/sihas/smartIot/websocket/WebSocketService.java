package org.atyeti.sihas.smartIot.websocket;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class WebSocketService {
    private final SimpMessagingTemplate template;

    public void sendDeviceUpdate(String deviceId, String msg) {
        WebSocketMessage m = new WebSocketMessage("DEVICE_UPDATE", deviceId, msg, Instant.now().toString());
        template.convertAndSend("/topic/device-updates", m);
    }

    public void sendUserAlert(String username, String msg) {
        WebSocketMessage m = new WebSocketMessage("ALERT", null, msg, Instant.now().toString());

        template.convertAndSendToUser(username, "/queue/alerts", m);
    }
}
