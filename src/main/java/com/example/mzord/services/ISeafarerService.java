package com.example.mzord.services;

import com.example.mzord.models.Certificate;
import com.example.mzord.models.Seafarer;

import java.util.*;

public interface ISeafarerService {

    public List<Seafarer> findAll();
    public Optional<Seafarer> findById(Long id);
    public Seafarer save(Seafarer seafarer);
    public Seafarer updateSeafarer(Seafarer seafarer);
    public Seafarer update(Long id, Map<String, String> requestJson);
    public List<Seafarer> showCrew();
    public List<Seafarer> sortByFunction();
    public List<Seafarer> showDisembarked();
}
