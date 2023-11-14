package edu.fag.petlove.services;

import edu.fag.petlove.exceptions.EntityPersistenceException;
import edu.fag.petlove.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class _GenericService<T> {
    @Autowired
    private JpaRepository<T, Long> repository;

    public List<T> findAll() {
        try {
            return repository.findAll();
        } catch (DataAccessException e) {
            throw new EntityPersistenceException("Failed to search entities", e);
        }
    }

    public T findById(Long id) {
        return repository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("ID " + id + " not found"));
    }

    public T save(T entity) {
        if (entity == null) {
            throw new EntityNotFoundException("Entity not found");
        }
        try {
            T savedProduct = updateTimestampBeforeSaving(entity);
            return repository.save(savedProduct);
        } catch (DataAccessException e) {
            throw new EntityPersistenceException("Failed to save entity", e);
        }
    }

    public T update(T entity) {
        Optional<T> sourceEntity = Optional.ofNullable(findById(getEntityId(entity)));
        if (sourceEntity.isEmpty()) {
            throw new EntityNotFoundException("Entity not found");
        }
        try {
            T updatedEntity = updateExistingEntity(sourceEntity.get(), entity);
            return repository.save(updatedEntity);
        } catch (DataAccessException e) {
            throw new EntityPersistenceException("Failed to update entity", e);
        }
    }

    public void delete(Long id) {
        Optional<T> entity = Optional.ofNullable(findById(id));
        if (entity.isEmpty()) {
            throw new EntityNotFoundException("ID " + id + " not found");
        }
        try {
            repository.deleteById(id);
        } catch (DataAccessException e) {
            throw new EntityPersistenceException("Failed to delete entity", e);
        }
    }

    protected abstract T updateTimestampBeforeSaving(T entity);

    protected abstract Long getEntityId(T entity);

    protected abstract T updateExistingEntity(T sourceEntity, T targetEntity);
}
