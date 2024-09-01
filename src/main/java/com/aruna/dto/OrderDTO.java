package com.aruna.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class OrderDTO {

    private String itmCode;
    private Integer numberOfOrderItem;
    private BigDecimal totalPrice;

}
