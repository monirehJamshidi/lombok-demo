package com.example.lombokdemo.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class OrderResponse {
    Long id;
    String product;
    int quantity;
    double price;
}
