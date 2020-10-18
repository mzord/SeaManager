package com.example.mzord.models;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

public class Crew {

    private Map.Entry<String, Seafarer> members;
    private List<Seafarer> seafarers;

    public Crew() {}

    public Crew(List<Seafarer> seafarerList) {
        this.seafarers = seafarerList;
    }

    public Map.Entry<String, Seafarer> getMembers() {
        return members;
    }

    public void setMembers(Map.Entry<String, Seafarer> members) {
        this.members = members;
    }

    public void setSeafarers(List<Seafarer> seafarerList) {
        this.seafarers = seafarerList;
    }

    public List<Seafarer> getSeafarers() {
        return this.seafarers;
    }

    public void populateMembers() {

    }



}
