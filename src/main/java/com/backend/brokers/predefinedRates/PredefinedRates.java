package com.backend.brokers.predefinedRates;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PredefinedRates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Boolean singlePrice;

    // Constructors, Getters and Setters

    public PredefinedRates() {}

    public PredefinedRates(String name, Boolean singlePrice) {
        this.name = name;
        this.singlePrice = singlePrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSinglePrice() {
        return singlePrice;
    }

    public void setSinglePrice(Boolean singlePrice) {
        this.singlePrice = singlePrice;
    }
}
