package com.example.mzord.services;

import com.example.mzord.models.Certificate;
import com.example.mzord.models.Seafarer;
import com.example.mzord.repositories.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class CertificateService implements ICertificateService {

    @Autowired
    private CertificateRepository certificateRepository;

    @Override
    public List<Certificate> findAll() {
        var allCertificates = (List<Certificate>) certificateRepository.findAll();
        return allCertificates;
    }

    @Override
    public HashSet<Certificate> findBySeafarer(Long id) {
        HashSet<Certificate> certificates = certificateRepository.findBycertOwner(id);
        return certificates;
    }

    @Override
    public HashSet<Certificate> saveAll(HashSet<Certificate> certificates) {
        HashSet<Certificate> allcerts = (HashSet<Certificate>) certificateRepository.saveAll(certificates);
        return allcerts;
    }

}
