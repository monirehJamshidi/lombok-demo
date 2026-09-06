package com.example.lombokdemo.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Order {
    private Long id;
    private String product;
    private int quantity;
    private double price;
}
