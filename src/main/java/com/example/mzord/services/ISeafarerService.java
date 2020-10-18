package com.example.mzord.services;

import com.example.mzord.models.Certificate;
import com.example.mzord.models.Seafarer;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ISeafarerService {

    public List<Seafarer> findAll();
    public Optional<Seafarer> findById(Long id);
    public Seafarer save(Seafarer seafarer);
    public List<Seafarer> showCrew();
    public List<Seafarer> sortByFunction();
}
