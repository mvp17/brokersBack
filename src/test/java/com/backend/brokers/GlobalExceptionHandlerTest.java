package com.backend.brokers;

import com.backend.brokers.exceptions.GlobalExceptionHandler;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler exceptionHandler = new GlobalExceptionHandler();

    @Test
    void testHandleBadCredentialsException() {
        BadCredentialsException exception = new BadCredentialsException("Invalid credentials");

        ProblemDetail response = exceptionHandler.handleSecurityException(exception);

        assertEquals(HttpStatus.UNAUTHORIZED.value(), response.getStatus());
        assertEquals("Invalid credentials", response.getDetail());
        assertEquals("The username or password is incorrect", Objects.requireNonNull(response.getProperties()).get("description"));
    }

    @Test
    void testHandleAccountStatusException() {
        AccountStatusException exception = new AccountStatusException("Account is locked") {};

        ProblemDetail response = exceptionHandler.handleSecurityException(exception);

        assertEquals(HttpStatus.FORBIDDEN.value(), response.getStatus());
        assertEquals("Account is locked", response.getDetail());
        assertEquals("The account is locked", Objects.requireNonNull(response.getProperties()).get("description"));
    }

    @Test
    void testHandleAccessDeniedException() {
        AccessDeniedException exception = new AccessDeniedException("Access denied");

        ProblemDetail response = exceptionHandler.handleSecurityException(exception);

        assertEquals(HttpStatus.FORBIDDEN.value(), response.getStatus());
        assertEquals("Access denied", response.getDetail());
        assertEquals("You are not authorized to access this resource", Objects.requireNonNull(response.getProperties()).get("description"));
    }

    @Test
    void testHandleSignatureException() {
        SignatureException exception = new SignatureException("Invalid JWT signature");

        ProblemDetail response = exceptionHandler.handleSecurityException(exception);

        assertEquals(HttpStatus.FORBIDDEN.value(), response.getStatus());
        assertEquals("Invalid JWT signature", response.getDetail());
        assertEquals("The JWT signature is invalid", Objects.requireNonNull(response.getProperties()).get("description"));
    }

    @Test
    void testHandleExpiredJwtException() {
        ExpiredJwtException exception = new ExpiredJwtException(null, null, "JWT has expired");

        ProblemDetail response = exceptionHandler.handleSecurityException(exception);

        assertEquals(HttpStatus.FORBIDDEN.value(), response.getStatus());
        assertEquals("JWT has expired", response.getDetail());
        assertEquals("The JWT token has expired", Objects.requireNonNull(response.getProperties()).get("description"));
    }

    @Test
    void testHandleUnknownException() {
        Exception exception = new Exception("Unknown error");

        ProblemDetail response = exceptionHandler.handleSecurityException(exception);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), response.getStatus());
        assertEquals("Unknown error", response.getDetail());
        assertEquals("Unknown internal server error.", Objects.requireNonNull(response.getProperties()).get("description"));
    }
}
