package com.example.mzord.models;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "seafarer")
public class Seafarer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seafarer_name;
    private String seafarer_register;
    private LocalDate seafarer_dob;
    private Boolean is_onboard;
    private LocalDate embark_date;
    private LocalDate disembark_date;

    @Enumerated(EnumType.STRING)
    private Rank seafarer_rank;

    @Enumerated(EnumType.STRING)
    private Function seafarer_function;

    public Seafarer() {}

    public Seafarer(Long id, String seafarer_name, String seafarer_register, LocalDate seafarer_dob, Boolean is_onboard, LocalDate embark_date, LocalDate disembark_date, Rank seafarer_rank, Function seafarer_function) {
        this.id = id;
        this.seafarer_name = seafarer_name;
        this.seafarer_register = seafarer_register;
        this.seafarer_dob = seafarer_dob;
        this.is_onboard = is_onboard;
        this.embark_date = embark_date;
        this.disembark_date = disembark_date;
        this.seafarer_rank = seafarer_rank;
        this.seafarer_function = seafarer_function;
    }

    public Long getId() {
        return id;
    }

    public String getSeafarer_name() {
        return seafarer_name;
    }

    public void setSeafarer_name(String seafarer_name) {
        this.seafarer_name = seafarer_name;
    }

    public String getSeafarer_register() {
        return seafarer_register;
    }

    public void setSeafarer_register(String seafarer_register) {
        this.seafarer_register = seafarer_register;
    }

    public LocalDate getSeafarer_dob() {
        return seafarer_dob;
    }

    public void setSeafarer_dob(LocalDate seafarer_dob) {
        this.seafarer_dob = seafarer_dob;
    }

    public Boolean getIs_onboard() {
        return is_onboard;
    }

    public void setIs_onboard(Boolean is_onboard) {
        this.is_onboard = is_onboard;
    }

    public LocalDate getEmbark_date() {
        return embark_date;
    }

    public void setEmbark_date(LocalDate embark_date) {
        this.embark_date = embark_date;
    }

    public LocalDate getDisembark_date() {
        return disembark_date;
    }

    public void setDisembark_date(LocalDate disembark_date) {
        this.disembark_date = disembark_date;
    }

    public Rank getSeafarer_rank() {
        return seafarer_rank;
    }

    public void setSeafarer_rank(Rank seafarer_rank) {
        this.seafarer_rank = seafarer_rank;
    }

    public Function getSeafarer_function() {
        return seafarer_function;
    }

    public void setSeafarer_function(Function seafarer_function) {
        this.seafarer_function = seafarer_function;
    }
}
