package com.damine.productservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

public interface AbstractController<ID,DTO> {
    @PostMapping
    ResponseEntity<DTO> save(@RequestBody DTO dto);
    @GetMapping("/{id}")
    ResponseEntity<DTO> getById(@PathVariable ID id);
    @PutMapping
    ResponseEntity<DTO> update(@RequestBody DTO dto);
    @GetMapping
    ResponseEntity<Collection<DTO>> findAll();
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable ID id);

}
