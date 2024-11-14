package com.backend.brokers.core;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/core")
public class BrokersController {
    @GetMapping("/brokers")
    public List<Broker> getBrokers() {
        return Arrays.asList(
                new Broker(1, "Broker 1"),
                new Broker(2, "Broker 2"),
                new Broker(3, "Broker 3"),
                new Broker(4, "Broker 4"),
                new Broker(5, "Broker 5"),
                new Broker(6, "Broker 6")
        );
    }
}
