package com.example.mzord.services;

import com.example.mzord.models.Seafarer;
import com.example.mzord.repositories.SeafarerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeafarerService implements ISeafarerService {

    @Autowired
    private SeafarerRepository repository;

    public List<Seafarer> findAll() {
        var seafarers = (List<Seafarer>) repository.findAll();

        return seafarers;
    }

    public Optional<Seafarer> findById(Long id) {
        Optional<Seafarer> seafarer = repository.findById(id);
        return seafarer;
    }

    @Override
    public Seafarer save(Seafarer seafarer) {
        return repository.save(seafarer);
    }
}
