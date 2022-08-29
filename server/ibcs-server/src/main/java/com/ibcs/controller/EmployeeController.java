package com.ibcs.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibcs.model.Department;
import com.ibcs.model.Employee;
import com.ibcs.service.EmployeeService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true")
@RequestMapping(value="/emp", produces = "application/json")
public class EmployeeController {

	private static final Logger log = LogManager.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping(value = "/insert/emp")
	public Employee insertEmp(@RequestBody Employee ep) {
		log.info("Insert Emp Controller [{}]", ep.getEmpName());
		
		Employee res = employeeService.insertEmp(ep);
		
		return res;
	}
	
	@GetMapping(value = "/get/all/emp")
	public List<Employee> getAllDept(){
		List<Employee> res = employeeService.getAllEmp();
		return res;
	}
	
	@PostMapping(value = "/delete/emp")
	public Employee deleteEmp(@RequestBody Employee ep) {
		log.info("Delete Emp Controller [{}]", ep.getEmpId());
		
		Employee res = employeeService.deleteEmp(ep);
		
		return res;
	}
	

}
