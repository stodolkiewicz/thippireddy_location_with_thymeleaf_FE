package com.bharath.location.controllers;

import com.bharath.location.entities.Location;
import com.bharath.location.repos.LocationRepository;
import com.bharath.location.service.LocationService;
import com.bharath.location.util.EmailUtil;
import com.bharath.location.util.ReportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import java.util.List;

@Controller
public class LocationController {

    @Autowired
    EmailUtil emailUtil;

    @Autowired
    ReportUtil reportUtil;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    LocationService locationService;

    @Autowired
    ServletContext servletContext;

    @RequestMapping("/showCreate")
    public String showCreate(){
        return "createLocation";
    }

    @RequestMapping("/saveLocation")
    public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap){
        Location locationSaved = locationService.saveLocation(location);
        String msg = "Location saved with id: " + locationSaved.getId();
        modelMap.addAttribute("msg", msg);
        //emailUtil.sendEmail("spammailera1@gmail.com", "Location saved", "Location saved successfuly and about to return a response.");
        return "createLocation";
    }

    @RequestMapping("/displayLocation")
    public String displayLocation(ModelMap modelMap){
        List<Location> locations = locationService.getAllLocations();
        modelMap.addAttribute("locations", locations);
        return "displayLocation";
    }

    @RequestMapping("/deleteLocation")
    public String deleteLocation(@RequestParam("id") int id){
        locationService.deleteLocation(id);
        return "redirect:displayLocation";
    }

    @RequestMapping("/showUpdate")
    public String showUpdate(@RequestParam("id") Integer id, Model model){
        Location location = locationService.getLocationById(id);
        model.addAttribute("location", location);
        return "updateLocation";
    }

    @RequestMapping("/updateLocation")
    public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap){
        locationService.updateLocation(location);
        return "redirect:displayLocation";
    }

    @RequestMapping("/generateReport")
    public String generateReport(){
        String path = servletContext.getRealPath("/");
        List<Object[]> data = locationRepository.findTypeAndTypeCount();
        reportUtil.generatePieChart(path, data);
        return "report";
    }

}




