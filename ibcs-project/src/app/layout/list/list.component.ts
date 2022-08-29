import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonService } from 'src/app/common.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {


  public employeeList : any = [];
  public departmentList : any = [];

  public showEmpList : boolean = true;
  public showDeptList : boolean = false;

  constructor(
    public cs : CommonService,
    public router : Router
  ) { }

  ngOnInit(): void {
  
    this.getAllEmp();
    this.getDeptList();

    if (this.cs.value == "DEPT") {
      this.onDeptClick();
      this.cs.value = null;
    }
    
  }

  getAllEmp(){
    debugger
    this.cs.get("/emp/get/all/emp").subscribe((res : any) =>{
      console.log(res);
      if (res) {
        this.employeeList = res;
      }
    })
  }

  getDeptList(){

    this.cs.get("/dept/get/all/dept").subscribe((res : any) =>{
      console.log(res)
      if(res){
        this.departmentList = res;
      }
    })
  }
  onViewClickIncident(data: any){
    console.log(data)
  }

  onEmpEditClick(data : any){

    debugger

    console.log(data)
    this.cs.data = data;
    this.router.navigate(['/emp/form']);
  }

  onEmpDeleteClick(data : any){
    debugger
    var payload = {
      empId : data.empId
    }
    this.cs.post(payload, "/emp/delete/emp").subscribe((res : any) =>{
      console.log(res)
      if (res) {
        alert("Employee Deleted")
        this.getAllEmp();
      }
    })
  }
  
  onDeptEditClick(data : any){
    debugger

    console.log(data)
    this.cs.data = data;
    this.router.navigate(['/dept/form']);
  }

  onDeptDeleteClick(data : any){

    debugger
    var payload = {
      deptId : data.deptId
    }
    this.cs.post(payload, "/dept/delete/dept").subscribe((res : any) =>{
      console.log(res)
      if (res) {
        alert("Department Deleted")
        this.getDeptList();
      }
    })
  }

  onEmpClick(){
    this.showEmpList = true
    this.showDeptList = false
  }

  onDeptClick(){
    this.showEmpList = false
    this.showDeptList = true
  }
}

