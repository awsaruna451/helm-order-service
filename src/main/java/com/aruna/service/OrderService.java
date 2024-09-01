package com.aruna.service;

import com.aruna.dto.OrderDTO;
import com.aruna.dto.OrderResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    public OrderResponseDTO placeOrder(OrderDTO orderDTO);
}
