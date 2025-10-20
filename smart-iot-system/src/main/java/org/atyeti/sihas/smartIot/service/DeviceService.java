package org.atyeti.sihas.smartIot.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.atyeti.sihas.smartIot.dto.request.DeviceRequest;
import org.atyeti.sihas.smartIot.dto.response.DeviceResponse;
import org.atyeti.sihas.smartIot.entity.Device;
import org.atyeti.sihas.smartIot.enums.DeviceStatus;
import org.atyeti.sihas.smartIot.enums.DeviceType;
import org.atyeti.sihas.smartIot.event.KafkaDeviceEventProducer;
import org.atyeti.sihas.smartIot.repository.DeviceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeviceService {

    private final DeviceRepository deviceRepository;
    private final KafkaDeviceEventProducer kafkaProducer;
    private final ModelMapper mapper;


    public DeviceResponse register(DeviceRequest req) {
        Device device = Device.builder()
                .deviceId(req.getDeviceId())
                .type(DeviceType.valueOf(String.valueOf(req.getType())))
                .location(req.getLocation())
                .status(DeviceStatus.OFF)
                .build();

        deviceRepository.save(device);
        return mapper.map(device, DeviceResponse.class);
    }


    public List<DeviceResponse> listAll() {
        return deviceRepository.findAll()
                .stream()
                .map(d -> mapper.map(d, DeviceResponse.class))
                .collect(Collectors.toList());
    }


    public void sendCommand(String deviceId, String command) {
        Device device = deviceRepository.findByDeviceId(deviceId)
                .orElseThrow(() -> new RuntimeException("Device not found: " + deviceId));

        kafkaProducer.sendCommand(deviceId, command);
        log.info("Command '{}' sent to device '{}'", command, deviceId);
    }


    public void updateStatusFromEvent(String deviceId, String payload) {
        Device device = deviceRepository.findByDeviceId(deviceId)
                .orElseThrow(() -> new RuntimeException("Device not found for update: " + deviceId));

        DeviceStatus status;
        try {
            status = DeviceStatus.valueOf(payload.toUpperCase());
        } catch (IllegalArgumentException e) {
            status = DeviceStatus.UNKNOWN;
        }

        device.setStatus(status);
        deviceRepository.save(device);

        log.info("Device '{}' status updated to '{}'", deviceId, status);
    }
}
