package com.example.inventoryservice.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Builder
public class ErrorResponse {

    private final Integer errorCode;
    private final String errorMessage;

}
