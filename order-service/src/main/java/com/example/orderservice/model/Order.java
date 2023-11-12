package com.example.orderservice.model;

import com.example.orderservice.common.BaseTime;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tbl_orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
public class Order extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_number")
    private String orderNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderLineItems> orderLineItemsList;

    @Builder
    public Order(Long id, String orderNumber, List<OrderLineItems> orderLineItemsList) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.orderLineItemsList = orderLineItemsList;
    }

    @Override
    public String toString() {
        return "id: " + id + ", orderNumber: " + orderNumber;
    }

}
