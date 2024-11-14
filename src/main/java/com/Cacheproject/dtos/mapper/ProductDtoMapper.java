package com.Cacheproject.dtos.mapper;

import com.Cacheproject.dtos.ProductDto;
import com.Cacheproject.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductDtoMapper {

    Product productDtoToProduct(ProductDto productDto);
}
