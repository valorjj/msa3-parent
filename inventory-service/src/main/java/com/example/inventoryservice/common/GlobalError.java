package com.example.inventoryservice.common;

import lombok.Getter;

@Getter
public class GlobalError extends RuntimeException {

    public GlobalError() {
    }

    public GlobalError(String message) {
        super(message);
    }
}
