package com.backend.brokers.modules.home.dtos;

public class SingleValue {
    private String name;
    private long value;

    // Constructors, Getters, and Setters
    public SingleValue(String name, long value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
