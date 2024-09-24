package com.backend.brokers.predefinedRates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PredefinedRatesService {
    @Autowired
    private PredefinedRatesRepository repository;

    public List<PredefinedRates> getAllRates() {
        return repository.findAll();
    }

    public Optional<PredefinedRates> getRateById(Integer id) {
        return repository.findById(id);
    }

    public PredefinedRates createRate(PredefinedRates rate) {
        return repository.save(rate);
    }

    public PredefinedRates updateRate(Integer id, PredefinedRates rateDetails) {
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
