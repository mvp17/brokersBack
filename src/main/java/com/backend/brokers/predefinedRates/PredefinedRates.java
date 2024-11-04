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

    private Boolean greenPower;

    private String rate;
    private String type;
    private Double marPotP1, marPotP2, marPotP3, marPotP4, marPotP5, marPotP6, marEneP1, marEneP2, marEneP3, marEneP4,
            marEneP5, marEneP6;

    public PredefinedRates(String name,
                           Boolean singlePrice,
                           String rate,
                           String type,
                           Double marPotP1,
                           Double marPotP2,
                           Double marPotP3,
                           Double marPotP4,
                           Double marPotP5,
                           Double marPotP6,
                           Double marEneP1,
                           Double marEneP2,
                           Double marEneP3,
                           Double marEneP4,
                           Double marEneP5,
                           Double marEneP6) {
        this.name = name;
        this.singlePrice = singlePrice;
        this.rate = rate;
        this.type = type;
        this.marPotP1 = marPotP1;
        this.marPotP2 = marPotP2;
        this.marPotP3 = marPotP3;
        this.marPotP4 = marPotP4;
        this.marPotP5 = marPotP5;
        this.marPotP6 = marPotP6;
        this.marEneP1 = marEneP1;
        this.marEneP2 = marEneP2;
        this.marEneP3 = marEneP3;
        this.marEneP4 = marEneP4;
        this.marEneP5 = marEneP5;
        this.marEneP6 = marEneP6;
    }

    public PredefinedRates() {

    }

    public Boolean getGreenPower() {
        return greenPower;
    }

    public void setGreenPower(Boolean greenPower) {
        this.greenPower = greenPower;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getMarPotP1() {
        return marPotP1;
    }

    public void setMarPotP1(Double marPotP1) {
        this.marPotP1 = marPotP1;
    }

    public Double getMarPotP2() {
        return marPotP2;
    }

    public void setMarPotP2(Double marPotP2) {
        this.marPotP2 = marPotP2;
    }

    public Double getMarPotP3() {
        return marPotP3;
    }

    public void setMarPotP3(Double marPotP3) {
        this.marPotP3 = marPotP3;
    }

    public Double getMarPotP4() {
        return marPotP4;
    }

    public void setMarPotP4(Double marPotP4) {
        this.marPotP4 = marPotP4;
    }

    public Double getMarPotP5() {
        return marPotP5;
    }

    public void setMarPotP5(Double marPotP5) {
        this.marPotP5 = marPotP5;
    }

    public Double getMarPotP6() {
        return marPotP6;
    }

    public void setMarPotP6(Double marPotP6) {
        this.marPotP6 = marPotP6;
    }

    public Double getMarEneP1() {
        return marEneP1;
    }

    public void setMarEneP1(Double marEneP1) {
        this.marEneP1 = marEneP1;
    }

    public Double getMarEneP2() {
        return marEneP2;
    }

    public void setMarEneP2(Double marEneP2) {
        this.marEneP2 = marEneP2;
    }

    public Double getMarEneP3() {
        return marEneP3;
    }

    public void setMarEneP3(Double marEneP3) {
        this.marEneP3 = marEneP3;
    }

    public Double getMarEneP4() {
        return marEneP4;
    }

    public void setMarEneP4(Double marEneP4) {
        this.marEneP4 = marEneP4;
    }

    public Double getMarEneP5() {
        return marEneP5;
    }

    public void setMarEneP5(Double marEneP5) {
        this.marEneP5 = marEneP5;
    }

    public Double getMarEneP6() {
        return marEneP6;
    }

    public void setMarEneP6(Double marEneP6) {
        this.marEneP6 = marEneP6;
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
