package edu.fag.petlove.handlers;

import edu.fag.petlove.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<CustomizedResponseException> handleAllExceptions(Exception exception, WebRequest request) {
        CustomizedResponseException customizedResponseException = new CustomizedResponseException(
            new Date(), exception.getMessage(), request.getDescription(false)
        );
        return new ResponseEntity<>(customizedResponseException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<CustomizedResponseException> handleNotFoundExceptions(Exception exception, WebRequest request) {
        CustomizedResponseException customizedResponseException = new CustomizedResponseException(
            new Date(), exception.getMessage(), request.getDescription(false)
        );
        return new ResponseEntity<>(customizedResponseException, HttpStatus.NOT_FOUND);
    }
}
