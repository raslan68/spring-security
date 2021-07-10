package com.ramiaslan.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException customException) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new GenericErrorResponse(400, customException.getMessage()));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> handleAccessDeniedException(AccessDeniedException accessDeniedException) {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(new GenericErrorResponse(403, "Access denied exception"));
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> handleNullPointerException(NullPointerException nullPointerException) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new GenericErrorResponse(400, "Null pointer exception"));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new GenericErrorResponse(500, "Internal server error"));
    }

}
