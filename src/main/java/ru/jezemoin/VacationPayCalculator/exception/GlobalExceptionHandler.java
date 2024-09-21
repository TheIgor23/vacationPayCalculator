package ru.jezemoin.VacationPayCalculator.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import ru.jezemoin.VacationPayCalculator.dto.ErrorMessage;


import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorMessage> handleMissingParams(MissingServletRequestParameterException ex) {
        ErrorMessage message = new ErrorMessage(
                "Missing required parameter: " + ex.getParameterName(),
                HttpStatus.BAD_REQUEST.value()
        );
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorMessage> handleValidationExceptions(ConstraintViolationException ex) {
        ErrorMessage message = new ErrorMessage(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value()
        );
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorMessage> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        ErrorMessage message = new ErrorMessage(
                "Parameter '" + ex.getName() + "' should be of type " + Objects.requireNonNull(ex.getRequiredType()).getSimpleName(),
                HttpStatus.BAD_REQUEST.value()
        );
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);

    }

}
