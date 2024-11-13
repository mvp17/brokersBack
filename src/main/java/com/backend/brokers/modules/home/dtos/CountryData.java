package com.backend.brokers.modules.home.dtos;

import java.util.List;

public class CountryData {
    private String name;
    private List<YearValuePair> series;

    // Constructors, Getters, and Setters
    public CountryData(String name, List<YearValuePair> series) {
        this.name = name;
        this.series = series;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<YearValuePair> getSeries() {
        return series;
    }

    public void setSeries(List<YearValuePair> series) {
        this.series = series;
    }
}
