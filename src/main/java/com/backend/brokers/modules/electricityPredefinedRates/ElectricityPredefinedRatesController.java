package com.backend.brokers.modules.electricityPredefinedRates;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/predefinedRates")
public class ElectricityPredefinedRatesController {
    private final ElectricityPredefinedRatesService service;

    public ElectricityPredefinedRatesController(ElectricityPredefinedRatesService service) {
        this.service = service;
    }

    // GET all rates
    @GetMapping
    public List<ElectricityPredefinedRates> getAllRates() {
        return service.getAllRates();
    }

    // GET rate by ID
    @GetMapping("/{id}")
    public ResponseEntity<ElectricityPredefinedRates> getRateById(@PathVariable Integer id) {
        return service.getRateById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // CREATE a new rate
    @PostMapping
    public ElectricityPredefinedRates createRate(@RequestBody ElectricityPredefinedRates rate) {
        return service.createRate(rate);
    }

    // UPDATE an existing rate
    @PutMapping("/{id}")
    public ResponseEntity<ElectricityPredefinedRates> updateRate(@PathVariable Integer id, @RequestBody ElectricityPredefinedRates rateDetails) {
        return ResponseEntity.ok(service.updateRate(id, rateDetails));
    }

    // DELETE a rate
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRate(@PathVariable Integer id) {
        service.deleteRate(id);
        return ResponseEntity.noContent().build();
    }
}
