package com.backend.brokers.predefinedRates;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PredefinedRatesRepository extends JpaRepository<PredefinedRates, Integer> {
}
