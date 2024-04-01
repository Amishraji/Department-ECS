package com.pranshu.crudproject.controller;


import com.pranshu.crudproject.exception.DepartmentNotFoundException;
import com.pranshu.crudproject.model.Department;
import com.pranshu.crudproject.repository.DepartmentRepository;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://frontend.route53testdemo.fun")
public class DepartmentController {
    
   
    private DepartmentRepository departmentRepository;
    public DepartmentController(DepartmentRepository departmentRepository)
    {
    	this.departmentRepository=departmentRepository;
    }
    @PostMapping("/department")
    @PreAuthorize("hasRole('admin')")
    Department newDepartment(@RequestBody Department newDepartment) {
    	return departmentRepository.save(newDepartment);
    }
    
    @GetMapping("/departments")
    List<Department>getAllDepartment(){
        return departmentRepository.findAll();
    }
    
    @GetMapping("/department/{id}")
    Department getDepartmentById(@PathVariable Long id){
        return departmentRepository.findById(id)
                .orElseThrow(()-> new DepartmentNotFoundException(id));
    }
    
    @PutMapping("/department/{id}")
    @PreAuthorize("hasRole('admin')")
    Department updateDepartment(@RequestBody Department newDepartment, @PathVariable Long id){
        return departmentRepository.findById(id)
                .map(department ->{
                    department.setDeptName(newDepartment.getDeptName());
                    department.setDescription(newDepartment.getDescription());
                    
                    return departmentRepository.save(department);
                }).orElseThrow(()->new DepartmentNotFoundException(id));
    }
    
    @DeleteMapping("/department/{id}")
    @PreAuthorize("hasRole('admin')")
    String deleteDepartment(@PathVariable Long id){
        if(!departmentRepository.existsById(id)){
            throw new DepartmentNotFoundException(id);
        }
        departmentRepository.deleteById(id);
        return "User with id "+id+" has been deleted successfully";
    }
    
}