package com.example.inventoryservice.common;


import com.example.inventoryservice.dto.ErrorResponse;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(GlobalError.class)
    public ResponseEntity<ErrorResponse> handleGlobalError(GlobalError ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(500, "잘못된 요청입니다."));
    }

}
