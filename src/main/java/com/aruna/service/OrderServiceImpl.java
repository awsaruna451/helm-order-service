package com.aruna.service;

import com.aruna.dto.ItemResponseDTO;
import com.aruna.dto.OrderDTO;
import com.aruna.dto.OrderResponseDTO;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class OrderServiceImpl implements OrderService {

    @Value("${item.service.url:http://localhost:8282}")
    public String itemServiceBackeUrl;

    private static String ITEM_SERVICE_BASE_URL="";

    @PostConstruct
    public void init() {
        ITEM_SERVICE_BASE_URL = itemServiceBackeUrl;
    }

    private final WebClient.Builder webClientBuilder;

    @Override
    public OrderResponseDTO placeOrder(OrderDTO orderDTO) {
        ItemResponseDTO itemResponseDTO = callItemOrderService(orderDTO).block();
        return OrderResponseDTO.builder().itmCode(itemResponseDTO.getItmCode())
                .totalPrice(itemResponseDTO.getTotalPrice())
                .numberOfItems(itemResponseDTO.getNumberOfItems()).build();
    }

    public  Mono<ItemResponseDTO> callItemOrderService(OrderDTO orderDTO) {

        WebClient webClient = webClientBuilder.baseUrl(ITEM_SERVICE_BASE_URL).build();
       // String uri = UriComponentsBuilder.fromPath("/api/items").build();

        return webClient.post()
                .uri("/api/items")
                .bodyValue(orderDTO)
                .retrieve()
                .bodyToMono(ItemResponseDTO.class)
                .doOnError(error -> {
                    // Handle error (optional error handling)
                    System.err.println("Error occurred: " + error.getMessage());
                });
    }
}


