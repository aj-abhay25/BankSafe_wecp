import { Inject, Injectable, Optional } from "@angular/core";
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

  constructor(@Optional() @Inject(HttpClient) private http: HttpClient) {}

  addCustomer(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>(`${this.baseUrl}/customers`, customer);
  }

  getAllCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(
      `${this.baseUrl}/customers`
    );
  }
  
  addAccount(account: Account): Observable<Account> {
    return this.http.post<Account>(`${this.baseUrl}/accounts`, account);
  }

  getAllAccounts(): Observable<Account[]> {
    return this.http.get<Account[]>(
      `${this.baseUrl}/accounts`
    );

  }

  performTransaction(transaction: Transaction): Observable<Transaction> {
    return this.http.post<Transaction>(
      `${this.baseUrl}/transactions`,
      transaction
    );
  }

  getOutstandingBalance(userId: string): Observable<number> {
    return this.http.get<number>(
      `${this.baseUrl}/out-standing?userId=${userId}`
    );

  }

  getAllTranactions(): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(
      `${this.baseUrl}/transactions`
    );

  }
  /** get account by user */
  getAccountsByUser(userId:string|null): Observable<Account[]> {
    return this.http.get<Account[]>(
      `${this.baseUrl}/accounts/user/${userId}`
    );

  }

  getTransactionByUser(userId: string|null): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(
      `${this.baseUrl}/transactions/customer/${userId}`
    );

  }

  deleteCustomer(customerId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/customers/${customerId}`);
  }

  editCustomer(customer: Customer): Observable<Customer> {
    console.log(customer);
    const url = `${this.baseUrl}/customers/${customer.customerId}`;
    return this.http.put<Customer>(url, customer);
  }

  deleteAccount(accountId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/accounts/${accountId}`);
  }

  editAccount(account: Account): Observable<Account> {
    console.log(account);
    const url = `${this.baseUrl}/accounts/${account.customer?.customerId}`;
    return this.http.put<Account>(url, account);
  }
}