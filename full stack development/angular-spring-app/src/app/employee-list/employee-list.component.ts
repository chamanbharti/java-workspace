import { Observable } from "rxjs";
import { EmployeeService } from "../employee.service";
import { Employee } from "./../employee";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: "app-employee-list",
  templateUrl: "./employee-list.component.html",
  styleUrls: ["./employee-list.component.css"]
})
export class EmployeeListComponent implements OnInit {
  employees: Observable<Employee[]>;

  constructor(private employeeService: EmployeeService,
    private router: Router) {}

  ngOnInit() {
    debugger
    this.reloadData();
  }

  reloadData() {
    debugger
    this.employees = this.employeeService.getEmployeesList();
  }

  deleteEmployee(id: number) {
    debugger
    this.employeeService.deleteEmployee(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  employeeDetails(id: number){
    debugger
    this.router.navigate(['details', id]);
  }

  updateEmployee(id: number){
    debugger
    this.router.navigate(['update', id]);
  }
}
