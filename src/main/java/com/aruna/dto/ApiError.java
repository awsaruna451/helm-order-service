package com.aruna.dto;

import org.springframework.http.HttpStatus;

public class ApiError {
    private HttpStatus status;
    private String message;

    public ApiError(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
