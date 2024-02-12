import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ApiResponse } from '../api.response';
import { AccountType } from '../model/account-type.model';

@Injectable({
  providedIn: 'root'
})
export class AccountTypeService {

  baseUrl: string = "http://localhost:8090";
  constructor(private httpClient: HttpClient) { }

  addAccountType(accountType: AccountType): Observable<ApiResponse> {
    return this.httpClient.post<ApiResponse>(this.baseUrl + "/account_type/add", accountType);
  }

  getAllAccountType(): Observable<AccountType> {
    return this.httpClient.get<AccountType>(this.baseUrl+"/account_type/all");
  }

  deleteAccountTypeById(id: number): Observable<ApiResponse> {
    return this.httpClient.delete<ApiResponse>(this.baseUrl+"/account_type/delete/"+id);
  }

  updateAccountType(id: number, accountType: AccountType): Observable<ApiResponse> {
    return this.httpClient.put<ApiResponse>(this.baseUrl+"/account_type/update/"+accountType.id , accountType);
  }

  getAccountTypeById(id: number): Observable<any> {
    return this.httpClient.get<any>(this.baseUrl+"/account_type/"+id);
  }
}
