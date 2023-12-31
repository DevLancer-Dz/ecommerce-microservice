package com.damine.productservice.controllers;

import com.damine.productservice.DTO.ProductDto;
import com.damine.productservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RequestMapping("/products")
@RestController
@RequiredArgsConstructor

public class ProductController implements AbstractController<Long, ProductDto>{
   private final ProductService productService;
    @Override
    public ResponseEntity<ProductDto> save(ProductDto productDto) {
        return new ResponseEntity<>(productService.save(productDto),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ProductDto> getById(Long id) {
        return new ResponseEntity<>(productService.findById(id),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDto> update(ProductDto productDto) {
        return new ResponseEntity<>(productService.update(productDto),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Collection<ProductDto>> findAll() {
        return new ResponseEntity<>(productService.findAll(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        productService.deleteByID(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Page<ProductDto>> getAll(int pageNumber, int pageSize, String sortField, String direction) {
        Pageable pageable=  PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.valueOf(direction),sortField));
        return new  ResponseEntity<>(productService.findAll(pageable),HttpStatus.OK);
    }
}
