package com.example.orderservice.common;

import jakarta.persistence.Column;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class BaseTime implements Serializable {

    @CreatedDate
    @Column(updatable = false, name = "created_at")
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedDate;

}
