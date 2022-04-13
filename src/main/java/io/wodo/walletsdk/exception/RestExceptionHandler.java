package io.wodo.walletsdk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.status;

@RestControllerAdvice
public class RestExceptionHandler {


    @ExceptionHandler(WalletNotFoundException.class)
    public ResponseEntity notFound(WalletNotFoundException ex, WebRequest req) {

        Map<String, String> errors = new HashMap<>();
        errors.put("message", ex.getMessage());
        errors.put("code", "not_found");
        errors.put("status", "404");
        return status(HttpStatus.NOT_FOUND).body(errors);
    }
}