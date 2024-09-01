package com.aruna.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class ItemResponseDTO {

    private String itmCode;
    private Integer numberOfItems;
    private BigDecimal totalPrice;

}
