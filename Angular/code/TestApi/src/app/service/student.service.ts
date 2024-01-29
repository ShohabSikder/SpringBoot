import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from '../model/student.model';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  private baseUrl="http://localhost:8086/api/student"

  constructor(private httpClient:HttpClient) {
    
}
getAllStudent():Observable<Student[]>{
  return this.httpClient.get<Student[]>(this.baseUrl);
}

getStudentById(id:number):Observable<Student>{
  return this.httpClient.get<Student>(this.baseUrl+"/"+id);
}
createStudent(student: Student): Observable<Student> {
  return this.httpClient.post<Student>(this.baseUrl,student);
}

updateStudent(id: number, student: Student): Observable<Student> {
  return this.httpClient.put<Student>(`${this.baseUrl}/${id}`, student);
}

deleteStudent(id: number): Observable<void> {
  return this.httpClient.delete<void>(`${this.baseUrl}/${id}`);
}
}
