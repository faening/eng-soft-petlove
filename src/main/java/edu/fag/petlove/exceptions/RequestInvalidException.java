package edu.fag.petlove.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequestInvalidException extends RuntimeException {
    public RequestInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestInvalidException(String message) {
        super(message);
    }
}
