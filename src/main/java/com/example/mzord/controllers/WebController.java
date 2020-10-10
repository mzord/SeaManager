package com.example.mzord.controllers;

import com.example.mzord.services.SeafarerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    @Autowired
    private SeafarerService seafarerService;

    @GetMapping("/")
    private String index() {
        return "index";
    }

    @GetMapping("/seafarer")
    private String seafarer() {
        return "showSeafarer";
    }


}
