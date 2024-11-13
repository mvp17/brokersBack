package com.backend.brokers.predefinedRates;

import com.backend.brokers.modules.predefinedRates.PredefinedRates;
import com.backend.brokers.modules.predefinedRates.PredefinedRatesController;
import com.backend.brokers.modules.predefinedRates.PredefinedRatesService;
import com.backend.brokers.modules.users.services.JwtService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.RequestPostProcessor;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PredefinedRatesController.class)
class PredefinedRatesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PredefinedRatesService service;

    @MockBean
    private JwtService jwtService;

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private UserDetails userDetails;

    private String jwtToken;

    @BeforeEach
    void setUp() {
        when(userDetails.getUsername()).thenReturn("testUser");
        when(jwtService.generateToken(any(UserDetails.class))).thenReturn("mocked-jwt-token");
        when(jwtService.isTokenValid(anyString(), eq(userDetails))).thenReturn(true);
        jwtToken = "Bearer Token " + jwtService.generateToken(userDetails);
    }

    // Helper method to add the JWT token to the request
    private RequestPostProcessor jwt() {
        //System.out.println(jwtToken);
        return request -> {
            request.addHeader("Authorization", jwtToken);
            return request;
        };
    }

    @Test
    @WithMockUser
    void testGetAllRates() throws Exception {
        // Arrange
        when(service.getAllRates()).thenReturn(Arrays.asList(new PredefinedRates("Rate1", true), new PredefinedRates("Rate2", false)));

        // Act & Assert
        mockMvc.perform(get("/api/rates").with(jwt()))  // Add JWT token to the request
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Rate1"))
                .andExpect(jsonPath("$[1].name").value("Rate2"));
    }

    @Test
    @WithMockUser
    void testGetRateById() throws Exception {
        // Arrange
        var rate = new PredefinedRates("Rate1", true);
        when(service.getRateById(1)).thenReturn(Optional.of(rate));

        // Act & Assert
        mockMvc.perform(get("/api/rates/1").with(jwt()))  // Add JWT token to the request
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Rate1"));
    }

    @Test
    @WithMockUser
    void testCreateRate() throws Exception {
        // Arrange
        var rate = new PredefinedRates("Rate1", true);
        when(service.createRate(any(PredefinedRates.class))).thenReturn(rate);

        // Act & Assert
        mockMvc.perform(post("/api/rates")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(rate))
                        .with(jwt()))  // Add JWT token to the request
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Rate1"));
    }

    @Test
    @WithMockUser
    void testUpdateRate() throws Exception {
        // Arrange
        var rate = new PredefinedRates("UpdatedRate", false);
        when(service.updateRate(eq(1), any(PredefinedRates.class))).thenReturn(rate);

        // Act & Assert
        mockMvc.perform(put("/api/rates/1")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(rate))
                        .with(jwt()))  // Add JWT token to the request
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("UpdatedRate"));
    }

    @Test
    @WithMockUser
    void testDeleteRate() throws Exception {
        // Act & Assert
        mockMvc.perform(delete("/api/rates/1").with(jwt()))  // Add JWT token to the request
                .andExpect(status().isNoContent());

        verify(service, times(1)).deleteRate(1);
    }
}
