import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Employee } from './employee';
import { EmployeeService } from './employee.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public employees: Employee[];
  public editEmployee: Employee | null = null;
  public deleteEmployee: Employee | null = null;


  constructor(private employeeService: EmployeeService){
    this.employees = [];
    // this.editEmployee = {};
    // this.deleteEmployee = {};
  }

  ngOnInit(){
    this.getEmployees();
  }

  public getEmployees(): void{
    this.employeeService.getEmployees().subscribe( // subscribe so that we can be notified whenever some data comes back from server
     (response: Employee[]) => {
       this.employees = response;
     },
     (error: HttpErrorResponse) => {
       alert(error.message);
     }
    );
  }

  public onAddEmployee(addForm: NgForm ): void{
    document.getElementById('add-employee-form')?.click();

      this.employeeService.addEmployees(addForm.value).subscribe(
        (response: Employee) => {
          console.log(response);
          this.getEmployees();
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        },
      );
  }

  public onUpdateEmployee(employee: Employee): void{
      this.employeeService.updateEmployees(employee).subscribe(
        (response: Employee) => {
          console.log(response);
          this.getEmployees();
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        },
      );
  }

  public onDeleteEmloyee(employeeId: number): void {
    this.employeeService.deleteEmployees(employeeId).subscribe(
      (response: void) => {
        console.log(response);
        this.getEmployees();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onOpenModal(employee: Employee | null, mode: string): void{
    const container = document.getElementById('main-container');
    const button = document.createElement('button');

    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle','modal');

    if(mode === 'add'){
      button.setAttribute('data-target', '#addEmployeeModal');
    }if(mode === 'edit'){
      this.editEmployee = employee;
      button.setAttribute('data-target', '#updateEmployeeModal');
    }if(mode === 'delete'){
      this.deleteEmployee = employee;
      button.setAttribute('data-target', '#deleteEmployeeModal');
    }

    container?.appendChild(button);

    button.click();
  }
   
  }

