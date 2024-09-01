package com.aruna.controller;

import com.aruna.dto.ApiResponse;
import com.aruna.dto.OrderDTO;
import com.aruna.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/")
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public ResponseEntity<ApiResponse> placeOrder(@RequestBody OrderDTO orderDTO) {
        // Logic for GET request
        ApiResponse response =  ApiResponse.builder().data(orderService.placeOrder(orderDTO)).success(true).build();
        return ResponseEntity.ok(response);
    }

}
