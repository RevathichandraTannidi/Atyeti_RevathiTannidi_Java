package org.atyeti.trafficManagement.service;

import jakarta.transaction.Transactional;
import org.atyeti.trafficManagement.controller.TrafficLightController;
import org.atyeti.trafficManagement.model.TrafficEvent;
import org.atyeti.trafficManagement.model.TrafficState;
import org.atyeti.trafficManagement.repository.TrafficEventRepository;
import org.springframework.stereotype.Service;

@Service
public class TrafiicServiceImpl implements TrafficService {
    private final TrafficEventRepository repo;
    private final TrafficLightController controller;

    public TrafiicServiceImpl(TrafficEventRepository repo, TrafficLightController controller) {
        this.repo = repo;
        this.controller = controller;
    }

    @Override
    @Transactional
    public void updateDensity(String dir, String level) {
        System.out.println("Updating density: " + dir + " - " + level);
      repo.save(new TrafficEvent("DENSITY",dir,level));
      controller.updateTrafficDensity(dir, level);
    }

    @Override
    @Transactional
    public void reportEmergency(String dir) {
        repo.save(new TrafficEvent("EMERGENCY", dir, null));
        controller.reportEmergency(dir);
    }

    @Override
    public TrafficState getState() {
        return controller.getState();
    }
}
