import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AccountType} from "../model/account-type.model";
import {Observable} from "rxjs";
import {ApiResponse} from "../api.response";
import {BankAccount} from "../model/bank-account.model";

@Injectable({
  providedIn: 'root'
})
export class BankAccountService {

  baseUrl: string = "http://localhost:8090";
  constructor(private httpClient: HttpClient) { }

  addBankAccount(bankAccount: BankAccount): Observable<ApiResponse> {
    return this.httpClient.post<ApiResponse>(this.baseUrl + "/bank_account/add", bankAccount);
  }

  getAllBankAccount(): Observable<BankAccount> {
    return this.httpClient.get<BankAccount>(this.baseUrl+"/bank_account/all");
  }

  deleteBankAccountById(id: number): Observable<ApiResponse> {
    return this.httpClient.delete<ApiResponse>(this.baseUrl+"/bank_account/delete/"+id);
  }

  updateBankAccount(id: number, bankAccount: BankAccount): Observable<ApiResponse> {
    return this.httpClient.put<ApiResponse>(this.baseUrl+"/bank_account/update/"+id, bankAccount);
  }

  getBankAccountById(id: number): Observable<any> {
    return this.httpClient.get<any>(this.baseUrl+"/bank_account/"+id);
  }
}
