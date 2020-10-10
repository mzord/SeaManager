package com.example.mzord.controllers;

import com.example.mzord.models.Seafarer;
import com.example.mzord.repositories.SeafarerRepository;
import com.example.mzord.services.ISeafarerService;
import com.example.mzord.services.SeafarerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SeafarerController {

    @Autowired
    private ISeafarerService seafarerService;

    // Show all seafarers from Database
    @GetMapping("/api/seafarers/all")
    public List<Seafarer> seafarerShow() {
        return seafarerService.findAll();
    }

    // Show specific seafarer using PathVariable 'id'
    @GetMapping("/api/seafarers/{id}")
    public Optional<Seafarer> findById(@PathVariable("id") Long id) {
        Optional<Seafarer> seafarer = seafarerService.findById(id);
        return seafarer;
    }

    // Post a new seafarer through body parameters
    @PostMapping("/api/seafarers")
    public Seafarer addSeafarer(@RequestBody Seafarer newSeafarer) {
        return seafarerService.save(newSeafarer);
    }

}
