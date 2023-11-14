package edu.fag.petlove.controllers;

import edu.fag.petlove.dto.ProductRequestDTO;
import edu.fag.petlove.dto.ProductResponseDTO;
import edu.fag.petlove.services.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Tag(name = "Products", description = "endpoints for managing products")
public class ProductController {
     @Autowired
     private ProductService productService;

    @Operation(
        summary = "Finds all products",
        description = "Finds all products",
        tags = { "Products" },
        responses = {
            @ApiResponse(
                description = "Success",
                responseCode = "200",
                content = {@Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = ProductResponseDTO.class))
                )}
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
        }
    )
    @GetMapping(
        produces = MediaType.APPLICATION_JSON_VALUE
    ) public List<ProductResponseDTO> findAll() {
        return productService.findAll();
    }

    @Operation(
        summary = "Find a product",
        description = "Find a product",
        tags = { "Products" },
        responses = {
            @ApiResponse(
                description = "Success",
                responseCode = "200",
                content = @Content(schema = @Schema(implementation = ProductResponseDTO.class))
            ),
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
        }
    )
    @GetMapping(
        value = "/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    ) public ProductResponseDTO findById(@PathVariable(value = "id") Long id) {
        return productService.findById(id);
    }

    @Operation(
        summary = "Save and return a product",
        description = "Save and return a product by JSON representation",
        tags = { "Products" },
        responses = {
            @ApiResponse(
                description = "Success",
                responseCode = "200",
                content = @Content(schema = @Schema(implementation = ResponseEntity.class))
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
        }
    )
    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    ) public ResponseEntity<?> save(@RequestBody ProductRequestDTO request) {
        ProductResponseDTO savedProduct = productService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct); // Status 201
    }

    @Operation(
        summary = "Update and return a product",
        description = "Update and return a product by JSON representation",
        tags = { "Products" },
        responses = {
            @ApiResponse(
                description = "Success",
                responseCode = "200",
                content = @Content(schema = @Schema(implementation = ResponseEntity.class))
            ),
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
        }
    )
    @PatchMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    ) public ResponseEntity<?> update(@RequestBody ProductRequestDTO request) {
        ProductResponseDTO updatedProduct = productService.update(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedProduct); // Status 200
    }

    @Operation(
        summary = "Delete a product and return status code 204 - no content",
        description = "Delete a product and return status code 204 - no content",
        tags = { "Products" },
        responses = {
            @ApiResponse(
                description = "No Content",
                responseCode = "204",
                content = @Content(schema = @Schema(implementation = ResponseEntity.class))
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
        }
    )
    @DeleteMapping(
        value = "/{id}"
    ) public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build(); // Status: 204 - No Content
    }
}
