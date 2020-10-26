package com.example.mzord.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

@Entity
public class CrewList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate createdOn;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate signDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureDate;

    private String lastPortOfCall;
    private String portOfArrival;
    private String signLocal;

    public CrewList(){}

    public CrewList(Long id, LocalDate signDate, LocalDate departureDate, String lastPortOfCall, String portOfArrival, String signLocal) {
        this.id = id;
        this.createdOn = LocalDate.now();
        this.signDate = signDate;
        this.departureDate = departureDate;
        this.lastPortOfCall = lastPortOfCall;
        this.portOfArrival = portOfArrival;
        this.signLocal = signLocal;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public LocalDate getSignDate() {
        return signDate;
    }

    public void setSignDate(LocalDate signDate) {
        this.signDate = signDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public String getLastPortOfCall() {
        return lastPortOfCall;
    }

    public void setLastPortOfCall(String lastPortOfCall) {
        this.lastPortOfCall = lastPortOfCall;
    }

    public String getPortOfArrival() {
        return portOfArrival;
    }

    public void setPortOfArrival(String portOfArrival) {
        this.portOfArrival = portOfArrival;
    }

    public String getSignLocal() {
        return signLocal;
    }

    public void setSignLocal(String signLocal) {
        this.signLocal = signLocal;
    }

}
