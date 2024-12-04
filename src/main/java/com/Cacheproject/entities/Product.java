package com.Cacheproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product extends BaseEntity implements Serializable {

    private String name;
    private String code;
    private int quantity;
    private double price;
    private String category;
    private String store;
}
