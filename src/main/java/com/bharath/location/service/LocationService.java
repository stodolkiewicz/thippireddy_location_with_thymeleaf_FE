package com.bharath.location.service;

import com.bharath.location.entities.Location;

import java.util.List;
import java.util.Optional;

public interface LocationService {

    Location saveLocation(Location lcoation);

    Location updateLocation(Location location);

    void deleteLocation(Location location);
    void deleteLocation(Integer id);

    Location getLocationById(Integer id);

    List<Location> getAllLocations();

}
