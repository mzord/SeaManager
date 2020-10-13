package com.example.mzord.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import com.example.mzord.models.Seafarer;
import com.example.mzord.services.ISeafarerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/seafarers")
public class SeafarerController {

    @Autowired
    private ISeafarerService seafarerService;

    // Show all seafarers from Database
    @GetMapping("/all")
    public List<Seafarer> showAll() {
        List<Seafarer> seafarers = seafarerService.findAll();
        for(Seafarer seafarer : seafarers) {
            seafarer.add(linkTo(methodOn(CertificateController.class)
                    .showCertificates(seafarer.getId()))
                    .withRel("Certificates:"));
        }
        return seafarers;
    }

    // Show specific seafarer using PathVariable 'id'
    @GetMapping("/{id}")
    public Optional<Seafarer> findById(@PathVariable("id") Long id) {
        Optional<Seafarer> seafarer = seafarerService.findById(id);
        seafarer.get().add(linkTo(methodOn(CertificateController.class)
                .showCertificates(seafarer.get().getId()))
                .withRel("Certificates:"));
        return seafarer;
    }

    // Post a new seafarer through body parameters
    @PostMapping("/add")
    public Seafarer addSeafarer(@RequestBody Seafarer newSeafarer) {
        return seafarerService.save(newSeafarer);
    }

    // Show crew onboard
    @GetMapping("/crew")
    public List<Seafarer> crew() {
        return seafarerService.showCrew();
    }

}
