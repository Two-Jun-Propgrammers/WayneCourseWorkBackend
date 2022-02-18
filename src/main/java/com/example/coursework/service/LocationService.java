package com.example.coursework.service;

import com.example.coursework.model.Location;
import com.example.coursework.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public List<UUID> findAll() {
        return locationRepository.findAll();
    }

    public Location search(UUID id) {
        return locationRepository.search(id);
    }

    public boolean create(Location location) {
        return locationRepository.create(location);
    }

    public boolean update(UUID id, Location location) {
        return locationRepository.update(id, location);
    }

    public boolean delete(UUID id) {
        return locationRepository.delete(id);
    }
}
