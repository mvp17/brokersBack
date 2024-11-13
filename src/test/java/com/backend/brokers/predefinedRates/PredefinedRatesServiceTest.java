package com.backend.brokers.predefinedRates;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.backend.brokers.modules.predefinedRates.PredefinedRates;
import com.backend.brokers.modules.predefinedRates.PredefinedRatesRepository;
import com.backend.brokers.modules.predefinedRates.PredefinedRatesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

class PredefinedRatesServiceTest {

    @Mock
    private PredefinedRatesRepository repository;

    @InjectMocks
    private PredefinedRatesService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initializes mocks
    }

    @Test
    void testGetAllRates() {
        // Arrange
        when(repository.findAll()).thenReturn(Arrays.asList(new PredefinedRates("Rate1", true), new PredefinedRates("Rate2", false)));

        // Act
        var rates = service.getAllRates();

        // Assert
        assertEquals(2, rates.size());
    }

    @Test
    void testGetRateById() {
        // Arrange
        var rate = new PredefinedRates("Rate1", true);
        when(repository.findById(1)).thenReturn(Optional.of(rate));

        // Act
        Optional<PredefinedRates> result = service.getRateById(1);

        // Assert
        assertTrue(result.isPresent());
        assertEquals("Rate1", result.get().getName());
    }

    @Test
    void testCreateRate() {
        // Arrange
        var rate = new PredefinedRates("Rate1", true);
        when(repository.save(rate)).thenReturn(rate);

        // Act
        var result = service.createRate(rate);

        // Assert
        assertEquals("Rate1", result.getName());
        assertTrue(result.getSinglePrice());
    }

    @Test
    void testUpdateRate() {
        // Arrange
        var existingRate = new PredefinedRates("Rate1", true);
        var updatedRate = new PredefinedRates("UpdatedRate", false);
        when(repository.findById(1)).thenReturn(Optional.of(existingRate));
        when(repository.save(any(PredefinedRates.class))).thenReturn(updatedRate);

        // Act
        PredefinedRates result = service.updateRate(1, updatedRate);

        // Assert
        assertEquals("UpdatedRate", result.getName());
        assertFalse(result.getSinglePrice());
    }

    @Test
    void testDeleteRate() {
        // Act
        service.deleteRate(1);

        // Assert
        verify(repository, times(1)).deleteById(1);
    }
}
