package com.bharath.location.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LocationController {

    @RequestMapping("/index")
    public String showCreate(){
        return "/index";
    }

}
