package com.ibcs.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibcs.controller.AppController;
import com.ibcs.model.Department;
import com.ibcs.repo.DepartmentRepo;

@Service
public class DepartmentService {
	
	private static final Logger log = LogManager.getLogger(DepartmentService.class);
	
	@Autowired
	DepartmentRepo departmentRepo;

	public Department insertDept(Department dp) {
		log.info("Insert Dept Service [{}]", dp.getDeptName());
		
		Department res = null;
		if (dp != null) {
			res = departmentRepo.save(dp);
		}
		return res;
	}

	public List<Department> getAllDept() {
		
		List<Department> res = departmentRepo.findAll();
		
		log.info("Dept Found [{}]", res.size());
		return res;
	}

	public Department deleteDept(Department dp) {
		log.info("Delete Dept [{}]", dp.getDeptName());
		
		if (dp != null) {
			departmentRepo.deleteById(dp.getDeptId());
		}
		
		return dp;
	}

}
