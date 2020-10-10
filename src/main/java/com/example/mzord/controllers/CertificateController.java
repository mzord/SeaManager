package com.example.mzord.controllers;

import com.example.mzord.models.Certificate;
import com.example.mzord.repositories.CertificateRepository;
import com.example.mzord.services.CertificateService;
import com.example.mzord.services.ICertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
public class CertificateController {

    @Autowired
    public ICertificateService certificateService;

    // Request all certs from a user
    @GetMapping("/api/certificates/{id}")
    public HashSet<Certificate> certificates(@PathVariable("id") Long id) {
        HashSet<Certificate> certificates = certificateService.findBySeafarer(id);
        return certificates;
    }

    // Create certificates from a list (JPA return it in a Iterable List)
    @PostMapping("/api/certificates")
    public Iterable<Certificate> addCertificate(@RequestBody HashSet<Certificate> newCertificates) {
        return certificateService.saveAll(newCertificates);
    }

}
