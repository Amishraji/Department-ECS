package com.pranshu.crudproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class DepartmentNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(DepartmentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)

    public Map<String,String> exceptionHandler(DepartmentNotFoundException exception){

        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", exception.getMessage());

        return errorMap;
    }
//    @ExceptionHandler(DepartmentNotFoundException.class)
//    public ResponseEntity<String> handleEmployeeNotFoundExceptionResponseEntity(DepartmentNotFoundException exception) {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
//    }
//    public class SecretsRetrievalException extends RuntimeException {
//        public SecretsRetrievalException(String message) {
//            super(message);
//        }
//    }
}
