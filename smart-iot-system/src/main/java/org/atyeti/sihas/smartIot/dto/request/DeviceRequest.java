package org.atyeti.sihas.smartIot.dto.request;


import lombok.Data;
import org.atyeti.sihas.smartIot.enums.DeviceType;

@Data
public class DeviceRequest {
    private String deviceId;
    private DeviceType type;
    private String location;
}
