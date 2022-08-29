package com.ibcs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibcs.model.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long>{

}
