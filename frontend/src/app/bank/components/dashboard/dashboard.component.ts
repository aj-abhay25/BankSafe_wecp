import { Component, OnInit } from '@angular/core';
import { BankService } from '../../services/bank.service';
import { Customer } from '../../types/Customer';
import { Observable } from 'rxjs';
import { Account } from '../../types/Account';
import { Transaction } from '../../types/Transaction';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth/services/auth.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  customers$: Observable<Customer[]>;
  accounts$: Observable<Account[]>

  customers: Customer[] = [];
  accounts: Account[] = [];

  transactions$: Observable<Transaction[]>
  transactions: Transaction[] = [];
  role: String | null;
  userRole: string;
  userId: number;
  constructor(private bankService: BankService, private router: Router) { }

  ngOnInit(): void {
    this.role = localStorage.getItem("role");
    const strUserId = localStorage.getItem("user_id");
    this.customers$ = this.bankService.getAllCustomers();
    this.loadAdminData();

    console.log(this.customers$);
    // this.userRole = localStorage.getItem('role');
    if (this.role == 'USER') {
      this.accounts$ = this.bankService.getAccountsByUser(strUserId);

      this.transactions$ = this.bankService.getTransactionByUser(strUserId);

    } else {
      this.accounts$ = this.bankService.getAllAccounts();
      console.log(this.accounts$);
      this.transactions$ = this.bankService.getAllTranactions();

    }
  }

  loadAdminData(): void {
    this.customers$ = this.bankService.getAllCustomers();
    this.accounts$ = this.bankService.getAllAccounts();
    this.transactions$ = this.bankService.getAllTranactions();

    // ✅ Subscribe to populate arrays for test access
    this.customers$.subscribe(data => this.customers = data);
    this.accounts$.subscribe(data => this.accounts = data);
    this.transactions$.subscribe(data => this.transactions = data);
  }


  deteteCustomer(customer: any): void {
    // alert(customer.customerId);
    let conf = confirm("Do You Really Want To Delete Customer");
    if (conf) {
      this.bankService.deleteCustomer(customer.customerId).subscribe(
        () => {
          alert('Customer deleted successfully.');

          // Remove the deleted customer from the local array
          this.customers$ = this.bankService.getAllCustomers();
        },
        (error) => {
          console.error('Error deleting customer:', error);
          // Handle error, show a message, etc.
        }
      );
    }
  }

  editCustomer(customer: Customer): void {
    this.router.navigate(['/bank/customer/edit', { customerId: customer.customerId, name: customer.name, email: customer.email, username: customer.username, password: customer.password, role: customer.role }]);
  }

  deteteAccount(account: any): void {
    // alert(customer.customerId);
    let conf = confirm("Do You Really Want To Delete Customer?");
    if (conf) {
      this.bankService.deleteAccount(account.accountId).subscribe(
        () => {
          alert('Account deleted successfully.');

          this.accounts$ = this.bankService.getAllAccounts();
        },
        (error) => {
          console.error('Error deleting customer: ', error);
        }
      );
    }
  }

  editAccount(account: any): void {
    console.log(account);
    this.router.navigate(['/bank/account/edit', {
      accountId: account.accountId, balance: account.balance, customerId: account.customer.customerId,
      name: account.customer.name, username: account.customer.username, password: account.customer.pasword, email: account.customer.email, role: account.customer.role
    }]);
  }

}