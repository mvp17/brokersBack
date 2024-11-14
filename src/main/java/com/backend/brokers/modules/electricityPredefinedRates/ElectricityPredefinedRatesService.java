package com.backend.brokers.modules.electricityPredefinedRates;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElectricityPredefinedRatesService {
    private final ElectricityPredefinedRatesRepository repository;

    public ElectricityPredefinedRatesService(ElectricityPredefinedRatesRepository repository) {
        this.repository = repository;
    }

    public List<ElectricityPredefinedRates> getAllRates() {
        return repository.findAll();
    }

    public Optional<ElectricityPredefinedRates> getRateById(Integer id) {
        return repository.findById(id);
    }

    public ElectricityPredefinedRates createRate(ElectricityPredefinedRates rate) {
        return repository.save(rate);
    }

    public ElectricityPredefinedRates updateRate(Integer id, ElectricityPredefinedRates rateDetails) {
        return repository.findById(id).map(rate -> {
            rate.setName(rateDetails.getName());
            rate.setSinglePrice(rateDetails.getSinglePrice());
            return repository.save(rate);
        }).orElseThrow(() -> new RuntimeException("Rate not found"));
    }

    public void deleteRate(Integer id) {
        repository.deleteById(id);
    }
}
