package edu.fag.petlove.controllers;

import edu.fag.petlove.dto.ProductRequestDTO;
import edu.fag.petlove.dto.ProductResponseDTO;
import edu.fag.petlove.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
     @Autowired
     private ProductService productService;

    @GetMapping(
        produces = MediaType.APPLICATION_JSON_VALUE
    ) public List<ProductResponseDTO> findAll() {
        return productService.findAll();
    }

    @GetMapping(
        value = "/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    ) public ProductResponseDTO findById(@PathVariable(value = "id") Long id) {
        return productService.findById(id);
    }

    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    ) public ResponseEntity<?> save(@RequestBody ProductRequestDTO request) {
        ProductResponseDTO savedProduct = productService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct); // Status 201
    }

    @PatchMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    ) public ResponseEntity<?> update(@RequestBody ProductRequestDTO request) {
        ProductResponseDTO updatedProduct = productService.update(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedProduct); // Status 200
    }

    @DeleteMapping(
        value = "/{id}"
    ) public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build(); // Status: 204 - No Content
    }
}
