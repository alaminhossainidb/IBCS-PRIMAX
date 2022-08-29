package com.ibcs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibcs.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}
