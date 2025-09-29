package com.tenpo.test.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tenpo.test.error.ApiError;

@ControllerAdvice
public class ExceptionHandlerController {

   @ExceptionHandler(RuntimeException.class)
   public ResponseEntity<ApiError> handleRuntimeException(RuntimeException ex) {
      ApiError error = new ApiError(
            "General error internal",
            ex.getMessage()
      );
      return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
   }

}
