package com.example.mzord.services;

import com.example.mzord.models.Seafarer;
import com.example.mzord.repositories.SeafarerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SeafarerService implements ISeafarerService {

    @Autowired
    private SeafarerRepository repository;

    @Override
    public List<Seafarer> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Seafarer> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Seafarer save(Seafarer seafarer) {
        return repository.save(seafarer);
    }

    @Override
    public List<Seafarer> showCrew() {
        List<Seafarer> seafarers = repository.findAll();
        return seafarers.stream()
                .filter(Seafarer::getIsOnboard)
                .collect(Collectors.toList());
    }
}
