package com.example.lombokdemo.service;

import com.example.lombokdemo.dto.OrderResponse;
import com.example.lombokdemo.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

//    private final OrderRepository orderRepository;

    public OrderResponse createOrder() {

        log.info("Creating a new order");

        Order order = Order.builder()
                .id(1L)
                .product("Laptop")
                .quantity(5)
                .price(1500.0)
                .build();

        log.debug("Order created with id: {}", order.getId());

        OrderResponse response = OrderResponse.builder()
                .id(order.getId())
                .product(order.getProduct())
                .quantity(order.getQuantity())
                .price(order.getPrice())
                .build();

//        response.setProduct("Phone");//error this class has not setter

        return response;
    }
}
