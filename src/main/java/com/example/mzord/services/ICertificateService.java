package com.example.mzord.services;

import com.example.mzord.models.Certificate;
import com.example.mzord.models.Seafarer;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public interface ICertificateService {

    public List<Certificate> findAll();
    public HashSet<Certificate> findBySeafarer(Long id);
    public HashSet<Certificate> saveAll(HashSet<Certificate> certificates);

}
