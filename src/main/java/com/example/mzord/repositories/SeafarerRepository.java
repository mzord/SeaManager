package com.example.mzord.repositories;

import com.example.mzord.models.Seafarer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;

@Repository
public interface SeafarerRepository extends JpaRepository<Seafarer, Long> {

    HashSet<Seafarer> findByIsOnboardTrue();

}
