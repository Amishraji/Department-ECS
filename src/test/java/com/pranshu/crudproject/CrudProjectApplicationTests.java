package com.pranshu.crudproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.pranshu.crudproject.model.Department;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CrudProjectApplicationTests {

    @Test
    void contextLoads() {
        // Create a Department object
        Department department = new Department();
        
        // Assert that the department object is not null
        assertNotNull(department, "Department object should not be null");
        
        // Add more assertions as needed
    }
}
