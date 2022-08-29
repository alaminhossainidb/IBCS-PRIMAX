import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonService } from 'src/app/common.service';

@Component({
  selector: 'app-dept-form',
  templateUrl: './dept-form.component.html',
  styleUrls: ['./dept-form.component.css']
})
export class DeptFormComponent implements OnInit {

  public deptId : number = 0;
  public deptName : string = "";
  public isActive : boolean = false;

  constructor(
    public cs : CommonService,
    public router : Router
  ) { }

  ngOnInit(): void {

    console.log(this.cs.data)

    if (this.cs.data != null) {
      var val = this.cs.data;
      
      this.deptId = val.deptId;
      this.deptName = val.deptName;
      this.isActive = val.isActive;
    }

    this.cs.data = null;
  }

  onSubmit(){
    debugger
  
    var payload = {
      deptId : this.deptId,
      deptName : this.deptName,
      isActive : this.isActive,
      
    }
  
    this.cs.post(payload, "/dept/insert/dept").subscribe((res : any) =>{
      console.log(res)
      if (res) {
        alert("Department Saving Successful")
        this.cs.value = "DEPT"
        this.router.navigate(["/home"])
      }
    })
    }

}
