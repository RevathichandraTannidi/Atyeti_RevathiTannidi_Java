package com.org.cabMate.service;

import com.org.cabMate.model.Rider;
import com.org.cabMate.dao.RiderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiderService {
    private final RiderRepository riderRepository;

    public RiderService(RiderRepository riderRepository) {
        this.riderRepository = riderRepository;
    }

    public Rider registerRider(Rider rider) {
        return riderRepository.save(rider);
    }

    public List<Rider> getAllRiders() {
        return riderRepository.findAll();
    }

    public Rider updateRiderLocation(Long riderId, double lat, double lon) {
        Rider rider = riderRepository.findById(riderId)
                .orElseThrow(() -> new RuntimeException("Rider not found"));
        rider.setLatitude(lat);
        rider.setLongitude(lon);
        return riderRepository.save(rider);
    }
}
