package com.pranshu.crudproject.repository;


import com.pranshu.crudproject.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentRepository extends JpaRepository<Department, Long>{

}