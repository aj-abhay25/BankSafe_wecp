import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";
import { HttpClient } from "@angular/common/http";
import { Transaction } from "../types/Transaction";
import { Observable } from "rxjs";
import { Customer } from "../types/Customer";
import { Account } from "../types/Account";
// import { transition } from "@angular/animations";

@Injectable({
  providedIn: "root",
})
export class BankService {
  private baseUrl = `${environment.apiUrl}`;

  constructor(private http: HttpClient) {}

  addCustomer(customer: Customer): Observable<Customer> {
  }

  getCustomers(): Observable<Customer[]> {
    

  }

  addAccount(account: Account): Observable<Account> {
   
  }

  getAccounts(): Observable<Account[]> {
    

  }

  performTransaction(transaction: Transaction): Observable<Transaction> {
   
  }

  getOutstandingBalance(userId: string): Observable<number> {
    
  }

  getAllTranactions(): Observable<Transaction[]> {
    

  }
  /** get account by user */
  getAccountsByUser(userId:string|null): Observable<Account[]> {
    

  }

  getTransactionByUser(userId: string|null): Observable<Transaction[]> {
    

  }

  deleteCustomer(customerId: number): Observable<any> {
    
  }

  editCustomer(customer: Customer): Observable<Customer> {
   
  }

  deleteAccount(accountId: number): Observable<any> {
    
  }

  editAccount(account: Account): Observable<Account> {
    // return null;
  }


}
