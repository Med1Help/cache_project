package com.Cacheproject.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPurchaseDto {
    private Long productId;
    private String code;
    private int quantity;
    private double price;
    private String store;
}
