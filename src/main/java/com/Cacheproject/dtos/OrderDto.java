package com.Cacheproject.dtos;

import com.Cacheproject.entities.Client;
import com.Cacheproject.entities.Product;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class OrderDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Product product;
    private Long qte;
    private String store;
    @ManyToOne
    private Client client;
}
