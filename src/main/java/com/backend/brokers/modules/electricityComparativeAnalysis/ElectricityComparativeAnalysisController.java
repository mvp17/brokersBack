package com.backend.brokers.modules.electricityComparativeAnalysis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/electricityComparativeAnalysis")
public class ElectricityComparativeAnalysisController {
    @GetMapping("/agencyRates")
    public List<AgencyRate> getAgencyRates() {
        return Arrays.asList(
                new AgencyRate(1, "Ag rate 1"),
                new AgencyRate(2, "Ag rate 2"),
                new AgencyRate(3, "Ag rate 3")
        );
    }
}
