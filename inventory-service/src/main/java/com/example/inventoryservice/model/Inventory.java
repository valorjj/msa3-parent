package com.example.inventoryservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_inventory")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sku_code")
    private String skuCode;

    @Column(name = "quantity")
    private Integer quantity;

    @Builder
    public Inventory(Long id, String skuCode, Integer quantity) {
        this.id = id;
        this.skuCode = skuCode;
        this.quantity = quantity;
    }

    public void decreaseQuantity(Integer number) {
        this.quantity -= number;
    }

}
