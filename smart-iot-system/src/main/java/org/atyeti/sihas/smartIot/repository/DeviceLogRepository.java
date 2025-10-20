package org.atyeti.sihas.smartIot.repository;

import org.atyeti.sihas.smartIot.entity.DeviceLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DeviceLogRepository extends JpaRepository<DeviceLog, Long> {
    List<DeviceLog> findByDeviceIdOrderByTsDesc(String deviceId);
}
