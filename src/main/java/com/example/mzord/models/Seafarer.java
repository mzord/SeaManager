package com.example.mzord.models;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "seafarer")
public class Seafarer extends RepresentationModel<Seafarer> {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seafarerName;
    private String seafarerRegister;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate seafarerDob;

    private Boolean isOnboard;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate embarkDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate disembarkDate;

    private String seafarerNationality;

    @Enumerated(EnumType.STRING)
    private Rank seafarerRank;

    @Enumerated(EnumType.STRING)
    private Function seafarerFunction;

    public Seafarer() {}

    public Seafarer(Long id, String seafarerName, String seafarerRegister, LocalDate seafarerDob, Boolean isOnboard, LocalDate embarkDate, LocalDate disembarkDate, Rank seafarerRank, Function seafarerFunction, String seafarerNationality) {
        this.id = id;
        this.seafarerName = seafarerName;
        this.seafarerRegister = seafarerRegister;
        this.seafarerDob = seafarerDob;
        this.isOnboard = isOnboard;
        this.embarkDate = embarkDate;
        this.disembarkDate = disembarkDate;
        this.seafarerRank = seafarerRank;
        this.seafarerFunction = seafarerFunction;
        this.seafarerNationality = seafarerNationality;
    }

    public Long getId() {
        return id;
    }

    public String getSeafarerName() {
        return seafarerName;
    }

    public void setSeafarerName(String seafarerName) {
        this.seafarerName = seafarerName;
    }

    public String getSeafarerRegister() {
        return seafarerRegister;
    }

    public void setSeafarerRegister(String seafarerRegister) {
        this.seafarerRegister = seafarerRegister;
    }

    public LocalDate getSeafarerDob() {
        return seafarerDob;
    }

    public void setSeafarerDob(LocalDate seafarerDob) {
        this.seafarerDob = seafarerDob;
    }

    public Boolean getIsOnboard() {
        return isOnboard;
    }

    public void setIsOnboard(Boolean is_onboard) {
        this.isOnboard = is_onboard;
    }

    public LocalDate getEmbarkDate() {
        return embarkDate;
    }

    public void setEmbarkDate(LocalDate embark_date) {
        this.embarkDate = embark_date;
    }

    public LocalDate getDisembarkDate() {
        return disembarkDate;
    }

    public void setDisembarkDate(LocalDate disembark_date) {
        this.disembarkDate = disembark_date;
    }

    public String getNationality() {
        return seafarerNationality;
    }

    public void setNationality(String nationality) {
        this.seafarerNationality = nationality;
    }

    public Rank getSeafarerRank() {
        return seafarerRank;
    }

    public void setSeafarerRank(Rank seafarerRank) {
        this.seafarerRank = seafarerRank;
    }

    public Function getSeafarerFunction() {
        return seafarerFunction;
    }

    public void setSeafarerFunction(Function seafarerFunction) {
        this.seafarerFunction = seafarerFunction;
    }
}
