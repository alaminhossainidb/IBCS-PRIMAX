import { DatePipe, formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonService } from 'src/app/common.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  public empId : number = 0;
  public empName : string = "";
  public empCode : string = "";
  public empDOB : any;
  public empMobile : string = "";
  public empGender : string = "";
  public empDeptId : any;

  public DepartrmentList : any = [];

  constructor(
    public cs : CommonService,
    public router : Router,
    public datePipe : DatePipe
  ) { }

  ngOnInit(): void {

    this.getDeptList();

    console.log(this.cs.data)
    if (this.cs.data != null) {
      var val = this.cs.data;
      debugger
      this.empId = val.empId;
      this.empName = val.empName;
      this.empDOB =  formatDate( val.empDOB, 'yyyy-MM-dd','en');
      this.empMobile = val.empMobileNo;
      this.empGender = val.empGender;
      this.empDeptId = val.empDeptId
      this.empCode = val.empCode;
      console.log(this.empDOB)
    }
    this.cs.data = null;
  }

  genUniqueCode(){
    var code : any = "";

    var val = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    for (let index = 0; index < 4; index++) {
     code += val. charAt(Math. floor(Math. random() * val.length));
      
    }
    return code;
  }

  onSubmit(){
  debugger
 
  if (this.empName.length < 2 || this.empName.length > 35) {
    
    alert("Name can not be less than 2 character and more than 35 character")

  }else{

    if (this.empId < 1) {
      
    this.empCode = this.genUniqueCode();
    }

    var payload = {
      empId : this.empId,
      empName : this.empName,
      empCode : this.empCode,
      empDOB : this.empDOB,
      empGender : this.empGender,
      empMobileNo : this.empMobile,
      empDeptId : this.empDeptId
    }

    this.cs.post(payload, "/emp/insert/emp").subscribe((res : any) =>{
      console.log(res)
      if (res) {
        alert("Employee Saving Successful")
        this.router.navigate(["/home"])
      }
    })
  }

  
  }

  onChangeType(rt : Event){
    
    var value = (rt.target as HTMLTextAreaElement).value
  }

  getDeptList(){

    this.cs.get("/dept/get/all/dept").subscribe((res : any) =>{
      console.log(res)
      if(res){
        this.DepartrmentList = res;
      }
    })
  }
}
