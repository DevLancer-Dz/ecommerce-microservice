package com.damine.productservice.mapper;

import com.damine.productservice.DTO.ProductDto;
import com.damine.productservice.models.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends AbstractMapper<Product, ProductDto>{
}
