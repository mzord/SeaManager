package com.example.mzord.repositories;

import com.example.mzord.models.Certificate;
import com.example.mzord.models.Seafarer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long> {

    HashSet<Certificate> findBycertOwner(Long certOwner);

}
