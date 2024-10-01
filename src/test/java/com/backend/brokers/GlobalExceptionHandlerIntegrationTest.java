package com.backend.brokers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GlobalExceptionHandlerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAccessDeniedException() throws Exception {
        mockMvc.perform(get("/api-test/access-denied"))
                .andExpect(status().isForbidden()) // 403
                .andExpect(jsonPath("$.status").value(403))
                .andExpect(jsonPath("$.detail").value("You are not authorized to access this resource"))
                .andExpect(jsonPath("$.description").value("You are not authorized to access this resource"));
    }

    @Test
    void testBadCredentialsException() throws Exception {
        mockMvc.perform(get("/api-test/bad-credentials"))
                .andExpect(status().isUnauthorized()) // 401
                .andExpect(jsonPath("$.status").value(401))
                .andExpect(jsonPath("$.detail").value("Invalid username or password"))
                .andExpect(jsonPath("$.description").value("The username or password is incorrect"));
    }

    @Test
    void testUnknownException() throws Exception {
        mockMvc.perform(get("/api-test/unknown-error"))
                .andExpect(status().isInternalServerError()) // 500
                .andExpect(jsonPath("$.status").value(500))
                .andExpect(jsonPath("$.detail").value("Unknown error occurred"))
                .andExpect(jsonPath("$.description").value("Unknown internal server error."));
    }
}
