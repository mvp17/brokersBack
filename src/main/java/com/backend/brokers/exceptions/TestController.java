package com.backend.brokers.exceptions;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-test")
public class TestController {

    @GetMapping("/access-denied")
    public String accessDenied() {
        throw new AccessDeniedException("You are not authorized to access this resource");
    }

    @GetMapping("/bad-credentials")
    public String badCredentials() {
        throw new BadCredentialsException("Invalid username or password");
    }

    @GetMapping("/unknown-error")
    public String unknownError() throws Exception {
        throw new Exception("Unknown error occurred");
    }
}
