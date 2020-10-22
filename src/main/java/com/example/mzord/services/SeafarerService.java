package com.example.mzord.services;

import com.example.mzord.models.Function;
import com.example.mzord.models.Rank;
import com.example.mzord.models.Seafarer;
import com.example.mzord.repositories.SeafarerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SeafarerService implements ISeafarerService {

    @Autowired
    private SeafarerRepository repository;

    @Override
    public List<Seafarer> findAll() {
        return repository.findByOrderByIdAsc();
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

    @Override
    public List<Seafarer> sortByFunction() {
        return repository.findByOrderBySeafarerFunctionAsc();
    }

    @Override
    public Seafarer updateSeafarer(Seafarer newSeafarer) {
        Optional<Seafarer> oldSeafarer = repository.findById(newSeafarer.getId());
        oldSeafarer.get().setDisembarkDate(newSeafarer.getDisembarkDate());
        oldSeafarer.get().setEmbarkDate(newSeafarer.getEmbarkDate());
        oldSeafarer.get().setIsOnboard(newSeafarer.getIsOnboard());
        oldSeafarer.get().setNationality(newSeafarer.getNationality());
        oldSeafarer.get().setSeafarerDob(newSeafarer.getSeafarerDob());
        oldSeafarer.get().setSeafarerFunction(newSeafarer.getSeafarerFunction());
        oldSeafarer.get().setSeafarerName(newSeafarer.getSeafarerName());
        oldSeafarer.get().setSeafarerRank(newSeafarer.getSeafarerRank());
        oldSeafarer.get().setSeafarerRegister(newSeafarer.getSeafarerRegister());

        repository.save(oldSeafarer.get());
        return oldSeafarer.get();
    }

    @Override
    public Seafarer update(Long id, Map<String, String> requestJson) {
        Optional<Seafarer> seafarerToUpdate = repository.findById(id);
        requestJson.forEach((key, value) -> {
            switch (key) {
                case "seafarerName":
                    seafarerToUpdate.get().setSeafarerName(value);
                    break;
                case "seafarerDob":
                    seafarerToUpdate.get().setSeafarerDob(LocalDate.parse(value));
                    break;
                case "seafarerRegister":
                    seafarerToUpdate.get().setSeafarerRegister(value);
                    break;
                case "isOnboard":
                    seafarerToUpdate.get().setIsOnboard(Boolean.parseBoolean(value));
                    break;
                case "embarkDate":
                    seafarerToUpdate.get().setEmbarkDate(LocalDate.parse(value));
                    break;
                case "disembarkDate":
                    seafarerToUpdate.get().setDisembarkDate(LocalDate.parse(value));
                    break;
                case "seafarerRank":
                    seafarerToUpdate.get().setSeafarerRank(Rank.valueOf(value));
                    break;
                case "seafarerFunction":
                    seafarerToUpdate.get().setSeafarerFunction(Function.valueOf(value));
                    break;
                case "nationality":
                    seafarerToUpdate.get().setNationality(value);
                    break;
                default:
                    break;
            }
        });
        repository.save(seafarerToUpdate.get());
        return seafarerToUpdate.get();
    }
}
