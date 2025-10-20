package org.atyeti.sihas.smartIot.websocket;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebSocketMessage {
    private String type;
    private String deviceId;
    private String message;
    private String timestamp;
}
