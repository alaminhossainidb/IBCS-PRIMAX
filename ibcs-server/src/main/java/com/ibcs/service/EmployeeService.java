package com.ibcs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibcs.model.Department;
import com.ibcs.model.Employee;
import com.ibcs.repo.DepartmentRepo;
import com.ibcs.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	private static final Logger log = LogManager.getLogger(EmployeeService.class);
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	@Autowired
	DepartmentRepo departmentRepo;

	public Employee insertEmp(Employee ep) {
		log.info("Insert Emp Service [{}]", ep.getEmpName());
		
		Employee res = null;
		if (ep != null) {
			res = employeeRepo.save(ep);
		}
		return res;
	}

	public List<Employee> getAllEmp() {
		List<Employee> res = new ArrayList<Employee>();
		List<Employee> emp = employeeRepo.findAll();
		
		log.info("Employee Found [{}]", emp.size());
		
		for (Employee employee : emp) {
			Employee e = new Employee();
			
			Optional<Department> d = departmentRepo.findById(Long.valueOf(employee.getEmpDeptId().toString()));
			
			e = employee;
			e.setDeptName(d.get().getDeptName());
			
			res.add(e);
			
		}
		return res;
	}

	public Employee deleteEmp(Employee ep) {
		log.info("Delete Employee  [{}]", ep.getEmpId());
		
		if (ep != null) {
			employeeRepo.deleteById(ep.getEmpId());
		}
		return ep;
	}

}
