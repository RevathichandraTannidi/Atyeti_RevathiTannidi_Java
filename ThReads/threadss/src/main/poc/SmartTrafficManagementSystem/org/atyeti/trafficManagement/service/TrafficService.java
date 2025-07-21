package org.atyeti.trafficManagement.service;


import org.atyeti.trafficManagement.model.TrafficState;

public interface TrafficService {
    void updateDensity(String dir, String level);
    void reportEmergency(String dir);
    TrafficState getState();
}
