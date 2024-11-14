package com.Cacheproject.services;

import com.Cacheproject.daos.ProductRepo;
import com.Cacheproject.dtos.ProductDto;
import com.Cacheproject.dtos.mapper.ProductDtoMapper;
import com.Cacheproject.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductDtoMapper productDtoMapper;
    private final ProductRepo productRepo;
    @Override
    public Product createProduct(ProductDto productDto) {
        Product product = productDtoMapper.productDtoToProduct(productDto);
        product = productRepo.save(product);
        return product;
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepo.findById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product updateProduct(Long id,ProductDto productDto) {
        Product product = productRepo.findById(id).get();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setCode(productDto.getCode());
        product.setQuantity(productDto.getQuantity());
        product.setCategory(productDto.getCategory());
        productRepo.save(product);
        return product;
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepo.findById(id).get();
        productRepo.delete(product);
    }
}
