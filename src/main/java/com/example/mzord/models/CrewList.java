package com.example.mzord.models;

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

    private LocalDate created_on;
    private LocalDate signDate;
    private LocalDate departureDate;

    private String lastPortOfCall;
    private String portOfArrival;
    private String signLocal;

//    private List<Seafarer> seafarers;

    public CrewList(){}

    public CrewList(Long id, LocalDate created_on, LocalDate signDate, LocalDate departureDate, String lastPortOfCall, String portOfArrival, String signLocal) {
        this.id = id;
        this.created_on = created_on;
        this.signDate = signDate;
        this.departureDate = departureDate;
        this.lastPortOfCall = lastPortOfCall;
        this.portOfArrival = portOfArrival;
        this.signLocal = signLocal;
//        this.seafarers = seafarers;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getCreated_on() {
        return created_on;
    }

    public void setCreated_on(LocalDate created_on) {
        this.created_on = created_on;
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

//    public List<Seafarer> getSeafarers() {
////        return seafarers;
//    }

    public void addSeafarer(Seafarer seafarer) {
//        this.seafarers.add(seafarer);
    }
}
