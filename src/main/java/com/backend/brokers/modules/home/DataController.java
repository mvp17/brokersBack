package com.backend.brokers.modules.home;

import com.backend.brokers.modules.home.dtos.CountryData;
import com.backend.brokers.modules.home.dtos.SingleValue;
import com.backend.brokers.modules.home.dtos.YearValuePair;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/home")
public class DataController {
    @GetMapping("/countries")
    public List<CountryData> getCountryData() {
        // Create series data for each country
        List<YearValuePair> germanySeries = Arrays.asList(
                new YearValuePair("2010", 7300000),
                new YearValuePair("2011", 8940000)
        );

        List<YearValuePair> usaSeries = Arrays.asList(
                new YearValuePair("2010", 7870000),
                new YearValuePair("2011", 8270000)
        );

        List<YearValuePair> franceSeries = Arrays.asList(
                new YearValuePair("2010", 5000002),
                new YearValuePair("2011", 5800000)
        );

        return Arrays.asList(
                new CountryData("Germany", germanySeries),
                new CountryData("USA", usaSeries),
                new CountryData("France", franceSeries)
        );
    }

    @GetMapping("/single")
    public List<SingleValue> getSingleValues() {
        return Arrays.asList(
                new SingleValue("Germany", 8940000),
                new SingleValue("USA", 5000000),
                new SingleValue("France", 7200000)
        );
    }
}
