package com.ibcs.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_emp_key")
	private Long empId;
	
	@Column(name = "tx_emp_name")
	private String empName;
	
	@Column(name = "tx_emp_code")
	private String empCode;
	
	@Column(name = "dtt_dob")
	private Date empDOB;
	
	@Column(name = "tx_emp_gender")
	private String empGender;
	
	@Column(name = "tx_emp_mobile_no")
	private String empMobileNo;
	
	@Column(name = "id_dept_key")
	private Long empDeptId;
	
	@Transient
	private String deptName;
	

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public Date getEmpDOB() {
		return empDOB;
	}

	public void setEmpDOB(Date empDOB) {
		this.empDOB = empDOB;
	}

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	public String getEmpMobileNo() {
		return empMobileNo;
	}

	public void setEmpMobileNo(String empMobileNo) {
		this.empMobileNo = empMobileNo;
	}

	public Long getEmpDeptId() {
		return empDeptId;
	}

	public void setEmpDeptId(Long empDeptId) {
		this.empDeptId = empDeptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
}
