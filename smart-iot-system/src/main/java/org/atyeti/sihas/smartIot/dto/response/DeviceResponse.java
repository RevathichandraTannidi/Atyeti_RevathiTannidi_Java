package org.atyeti.sihas.smartIot.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.atyeti.sihas.smartIot.enums.DeviceStatus;
import org.atyeti.sihas.smartIot.enums.DeviceType;

@Data
@Builder
@AllArgsConstructor
public class DeviceResponse {
    private String deviceId;
    private DeviceType type;
    private String location;
    private DeviceStatus status;

}
