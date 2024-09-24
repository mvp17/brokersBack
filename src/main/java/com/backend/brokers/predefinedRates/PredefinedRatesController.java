package com.backend.brokers.predefinedRates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rates")
public class PredefinedRatesController {
    @Autowired
    private PredefinedRatesService service;

    // GET all rates
    @GetMapping
    public List<PredefinedRates> getAllRates() {
        return service.getAllRates();
    }

    // GET rate by ID
    @GetMapping("/{id}")
    public ResponseEntity<PredefinedRates> getRateById(@PathVariable Integer id) {
        return service.getRateById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // CREATE a new rate
    @PostMapping
    public PredefinedRates createRate(@RequestBody PredefinedRates rate) {
        return service.createRate(rate);
    }

    // UPDATE an existing rate
    @PutMapping("/{id}")
    public ResponseEntity<PredefinedRates> updateRate(@PathVariable Integer id, @RequestBody PredefinedRates rateDetails) {
        return ResponseEntity.ok(service.updateRate(id, rateDetails));
    }

    // DELETE a rate
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRate(@PathVariable Integer id) {
        service.deleteRate(id);
        return ResponseEntity.noContent().build();
    }
}
