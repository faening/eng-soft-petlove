package edu.fag.petlove.controllers;

import edu.fag.petlove.services._GenericService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class _GenericController<T> {
    protected abstract _GenericService<T> getService();

    @GetMapping(
        produces = MediaType.APPLICATION_JSON_VALUE
    ) public List<T> findAll() {
        return getService().findAll();
    }

    @GetMapping(
        value = "/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    ) public T findById(@PathVariable(value = "id") Long id) {
        return getService().findById(id);
    }

    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    ) public T save(@RequestBody T entity) {
        return getService().save(entity);
    }

    @PatchMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    ) public T update(@RequestBody T entity) {
        return getService().update(entity);
    }

    @DeleteMapping(
        value = "/{id}"
    ) public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        getService().delete(id);
        return ResponseEntity.noContent().build(); // Status: 204 - No Content
    }
}
