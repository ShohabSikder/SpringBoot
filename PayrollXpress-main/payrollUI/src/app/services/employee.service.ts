import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AccountType} from "../model/account-type.model";
import {Observable} from "rxjs";
import {ApiResponse} from "../api.response";
import {Employee} from "../model/employee.model";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  baseUrl: string = "http://localhost:8090";
  constructor(private httpClient: HttpClient) { }

  addEmployee(employee: Employee): Observable<ApiResponse> {
    return this.httpClient.post<ApiResponse>(this.baseUrl + "/employee/add", employee);
  }

  getAllEmployee(): Observable<Employee> {
    return this.httpClient.get<Employee>(this.baseUrl+"/employee/all");
  }

  deleteEmployeeById(id: number): Observable<ApiResponse> {
    return this.httpClient.delete<ApiResponse>(this.baseUrl+"/employee/delete/"+id);
  }

  updateEmployee(id: number, employee: Employee): Observable<ApiResponse> {
    return this.httpClient.put<ApiResponse>(this.baseUrl+"/employee/update/"+employee.id , employee);
  }

  getEmployeeById(id: number): Observable<any> {
    return this.httpClient.get<any>(this.baseUrl+"/employee/"+id);
  }
}
