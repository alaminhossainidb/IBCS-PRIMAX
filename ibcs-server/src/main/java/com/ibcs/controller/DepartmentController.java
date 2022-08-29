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
import com.ibcs.service.DepartmentService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true")
@RequestMapping(value="/dept", produces = "application/json")
public class DepartmentController {
	
	private static final Logger log = LogManager.getLogger(DepartmentController.class);
	
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping(value = "/insert/dept")
	public Department insertDept(@RequestBody Department dp) {
		log.info("Insert Dept Controller [{}]", dp.getDeptName());
		
		Department res = departmentService.insertDept(dp);
		
		return res;
	}
	
	@GetMapping(value = "/get/all/dept")
	public List<Department> getAllDept(){
		List<Department> res = departmentService.getAllDept();
		return res;
	}

	@PostMapping(value = "/delete/dept")
	public Department deleteDept(@RequestBody Department dp) {
		log.info("Delete Dept Controller [{}]", dp.getDeptId());
		
		Department res = departmentService.deleteDept(dp);
		
		return res;
	}
}
