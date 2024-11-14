package com.Cacheproject.services;

import com.Cacheproject.dtos.ProductDto;
import com.Cacheproject.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    // Create a new product
    Product createProduct(ProductDto productDto);

    // Retrieve a product by its ID
    Optional<Product> getProductById(Long id);

    // Retrieve all products
    List<Product> getAllProducts();

    // Update an existing product
    Product updateProduct(Long id, ProductDto productDto);

    // Delete a product by its ID
    void deleteProduct(Long id);

}
