package com.example.mzord.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import com.example.mzord.models.Seafarer;
import com.example.mzord.services.DocParser;
import com.example.mzord.services.ISeafarerService;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.xmlbeans.XmlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

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

    @PutMapping("/update")
    public List<Seafarer> updateSeafarers(@RequestBody List<Seafarer> seafarerList) {
        List<Seafarer> updatedSeafarers = new ArrayList<>();
        seafarerList.forEach(
                seafarer -> {
                    seafarerService.updateSeafarer(seafarer);
                }
        );
        return seafarerList;
    }

    @PutMapping("/update/{id}")
    public void updateSeafarerById(@PathVariable Long id, @RequestBody Map<String, String> requestJson) {
        seafarerService.update(id, requestJson);
    }

}
