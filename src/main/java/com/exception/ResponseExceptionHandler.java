package com.exception;

import com.exception.contract.ContractException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    protected ResponseEntity<Object> handleBadRequest(PlatformException ex) {
        return new ResponseEntity<>(buildErrorMap(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ContractException.class)
    protected ResponseEntity<Object> handleConflictRequest(PlatformException ex) {
        return new ResponseEntity<>(buildErrorMap(ex.getMessage()), HttpStatus.CONFLICT);
    }

    private Map<String, String> buildErrorMap(String errorValue) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error", errorValue);
        return errorMap;
    }
}