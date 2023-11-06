package com.example.orderservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

public class OrderRequestDTO {

    private OrderRequestDTO() {
    }


    @Data
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class PlaceOrderRequest {
        /*
        * List 처럼 Collection 으로 받는 경우,
        * @JsonNaming 을 설정한 경우에도
        * @JsonProperty 를 한번 더 적어줘야 정상적으로 데이터 바인딩이 일어남을 확인했다.
        * */
        @JsonProperty("item_list")
        private List<OrderLineItemsRequestDTO.OrderRequestItem> itemDTOList;

    }

}