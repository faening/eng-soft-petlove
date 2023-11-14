package edu.fag.petlove.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class EntityPersistenceException extends RuntimeException {
    public EntityPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityPersistenceException(String message) {
        super(message);
    }
}
