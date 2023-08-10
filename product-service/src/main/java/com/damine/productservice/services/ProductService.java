package com.damine.productservice.services;

import com.damine.productservice.DTO.ProductDto;
import com.damine.productservice.exceptions.ResourceNotFoundException;
import com.damine.productservice.mapper.ProductMapper;
import com.damine.productservice.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class ProductService implements DAO<ProductDto, Long> {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto save(ProductDto dto) {
        return productMapper.to(productRepository.save(productMapper.from(dto)));
    }

    @Override
    public ProductDto findById(Long id) {
        return productMapper.to(productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found")));
    }

    @Override
    public ProductDto update(ProductDto dto) {
        findById(dto.getId());
        return productMapper.to(productRepository.save(productMapper.from(dto)));
    }

    @Override
    public void deleteByID(Long id) {
        findById(id);
        productRepository.deleteById(id);
    }

    @Override
    public Collection<ProductDto> findAll() {
        return productMapper.to(productRepository.findAll());
    }

    @Override
    public Page<ProductDto> findAll(Pageable pageable) {
        return productMapper.to(productRepository.findAll(pageable));
    }
}
