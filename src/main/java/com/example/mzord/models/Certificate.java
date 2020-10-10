package com.example.mzord.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "certificate")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String certName;
    private LocalDate certEmissionDate;
    private LocalDate certExpiryDate;
    private String certNumber;
    private Long certOwner;

    public Certificate(Long id,
                       String certName,
                       LocalDate certEmissionDate,
                       LocalDate certExpiryDate,
                       String certNumber,
                       Long certOwner) {
        this.id = id;
        this.certName = certName;
        this.certEmissionDate = certEmissionDate;
        this.certExpiryDate = certExpiryDate;
        this.certNumber = certNumber;
        this.certOwner = certOwner;
    }

    public Certificate() {}

    public Long getId() {
        return id;
    }

    public String getCertName() {
        return certName;
    }

    public void setCertName(String certName) {
        this.certName = certName;
    }

    public LocalDate getCertEmissionDate() {
        return certEmissionDate;
    }

    public void setCertEmissionDate(LocalDate certEmissionDate) {
        this.certEmissionDate = certEmissionDate;
    }

    public LocalDate getCertExpiryDate() {
        return certExpiryDate;
    }

    public void setCertExpiryDate(LocalDate certExpiryDate) {
        this.certExpiryDate = certExpiryDate;
    }

    public String getCertNumber() {
        return certNumber;
    }

    public void setCertNumber(String certNumber) {
        this.certNumber = certNumber;
    }

    public Long getCertOwner() {
        return certOwner;
    }

    public void setCertOwner(Long certOwner) {
        this.certOwner = certOwner;
    }

    @Override
    public String toString() {
        return "<Certificate " + this.certName +">";
    }
}
