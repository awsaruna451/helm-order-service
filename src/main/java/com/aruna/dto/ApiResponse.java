package com.aruna.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ApiResponse<T> {
    private boolean success;
    private T data;
    private ApiError error;
}
