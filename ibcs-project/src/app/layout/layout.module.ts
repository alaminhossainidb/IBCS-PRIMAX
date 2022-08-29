import { NgModule } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';

import { LayoutRoutingModule } from './layout-routing.module';
import { LayoutComponent } from './layout.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ListComponent } from './list/list.component';
import { FormComponent } from './form/form.component';
import { FormsModule } from '@angular/forms';
import { DeptFormComponent } from './dept-form/dept-form.component';


@NgModule({
  declarations: [
    LayoutComponent,
    NavbarComponent,
    ListComponent,
    FormComponent,
    DeptFormComponent
  ],
  imports: [
    CommonModule,
    LayoutRoutingModule,
    FormsModule
  ],
  providers : [DatePipe]
})
export class LayoutModule { }
