package org.atyeti.sihas.smartIot.event;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceEvent {
    private String deviceId;
    private String status;
    private String timestamp;
}

