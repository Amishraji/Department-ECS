package com.pranshu.crudproject.exception;

public class DepartmentNotFoundException extends RuntimeException{
    public DepartmentNotFoundException(Long id){
        super("Could not found the Department with id "+ id);
    }
}
