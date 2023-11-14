package edu.fag.petlove.controllers;

import edu.fag.petlove.models.Brand;
import edu.fag.petlove.services.BrandService;
import edu.fag.petlove.services._GenericService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
@Tag(name = "Brands", description = "endpoints for managing brands")
public class BrandController extends _GenericController<Brand> {
    @Autowired
    BrandService brandService;

    @Override
    @Operation(
        summary = "Finds all brands",
        description = "Finds all brands",
        tags = { "Brands" },
        responses = {
            @ApiResponse(
                description = "Success",
                responseCode = "200",
                content = {@Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = Brand.class))
                )}
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
        }
    )
    @GetMapping(
        produces = MediaType.APPLICATION_JSON_VALUE
    ) public List<Brand> findAll() {
        return super.findAll();
    }

    @Override
    @Operation(
        summary = "Find a brand",
        description = "Find a brand",
        tags = { "Brands" },
        responses = {
            @ApiResponse(
                description = "Success",
                responseCode = "200",
                content = @Content(schema = @Schema(implementation = Brand.class))
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
    ) public Brand findById(@PathVariable(value = "id") Long id) {
        return super.findById(id);
    }

    @Override
    @Operation(
        summary = "Save and return a brand",
        description = "Save and return a brand by JSON representation",
        tags = { "Brands" },
        responses = {
            @ApiResponse(
                description = "Success",
                responseCode = "200",
                content = @Content(schema = @Schema(implementation = Brand.class))
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
        }
    )
    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    ) public Brand save(@RequestBody Brand entity) {
        return super.save(entity);
    }

    @Override
    @Operation(
        summary = "Update and return a brand",
        description = "Update and return a brand by JSON representation",
        tags = { "Brands" },
        responses = {
            @ApiResponse(
                description = "Success",
                responseCode = "200",
                content = @Content(schema = @Schema(implementation = Brand.class))
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
    ) public Brand update(@RequestBody Brand entity) {
        return super.update(entity);
    }

    @Override
    @Operation(
        summary = "Delete a brand and return status code 204 - no content",
        description = "Delete a brand and return status code 204 - no content",
        tags = { "Brands" },
        responses = {
            @ApiResponse(
                description = "No Content",
                responseCode = "204",
                content = @Content(schema = @Schema(implementation = Brand.class))
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
        }
    )
    @DeleteMapping(
        value = "/{id}"
    ) public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        return super.delete(id);
    }

    @Override
    protected _GenericService<Brand> getService() {
        return brandService;
    }
}
