import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DeptFormComponent } from './dept-form/dept-form.component';
import { FormComponent } from './form/form.component';
import { LayoutComponent } from './layout.component';
import { ListComponent } from './list/list.component';

const routes: Routes = [
  {
    path : '',
    component : LayoutComponent,
    children : [
        {
          path : '',
          component : ListComponent
        },
        {
          path : 'home',
          component : ListComponent
        },
        {
          path : 'emp/form',
          component : FormComponent
        },
        {
          path : 'dept/form',
          component : DeptFormComponent
        }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LayoutRoutingModule { }
