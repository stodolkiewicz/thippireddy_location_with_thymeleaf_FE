package com.bharath.location.service;

import com.bharath.location.entities.Location;
import com.bharath.location.repos.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService{

    @Autowired
    LocationRepository locationRepository;

    @Override
    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location updateLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public void deleteLocation(Location location) {
        locationRepository.delete(location);
    }

    @Override
    public Optional<Location> getLocationById(Integer id) {
        return locationRepository.findById(id);
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}
