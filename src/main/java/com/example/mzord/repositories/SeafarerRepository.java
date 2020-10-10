package com.example.mzord.repositories;

import com.example.mzord.models.Seafarer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeafarerRepository extends JpaRepository<Seafarer, Long> {

}
