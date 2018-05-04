package com.bharath.location.controllers;

import com.bharath.location.entities.Location;
import com.bharath.location.repos.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationRESTController {

    @Autowired
    LocationRepository locationRepository;

    @GetMapping
    public List<Location> getAllLcoations(){
        return locationRepository.findAll();
    }

    @PostMapping
    public Location createLocation(@RequestBody Location location){
        return locationRepository.save(location);
    }

    @PutMapping
    public Location updateLocation(@RequestBody Location location){
        return locationRepository.save(location);
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable int id){
        locationRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Location getLocation(@PathVariable int id){
        return locationRepository.findById(id).orElse(null);
    }

}
