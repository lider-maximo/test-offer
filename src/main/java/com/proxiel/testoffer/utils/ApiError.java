package com.proxiel.testoffer.utils;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

/**
 * ApiError entity for constructing Errors in Response Entity
 *
 * @author Hassan Jroundi
 * @version 1.0
 */
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiError {

    HttpStatus status;
    String message;

    /**
     * No Args Constructor
     */
    public ApiError() {
        super();
    }

    /**
     * All Args Constructor
     *
     * @param status
     * @param message
     */
    public ApiError(final HttpStatus status, final String message) {
        super();
        this.status = status;
        this.message = message;
    }

    // Getters and Setters

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(final HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

}
