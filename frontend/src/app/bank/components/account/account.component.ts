import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BankService } from '../../services/bank.service';
import { Observable, of } from 'rxjs';
import { Account } from '../../types/Account';
import { Customer } from '../../types/Customer';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent implements OnInit {
  customers$: Observable<Customer[]>;
  customers: Customer[] = [];
  accountForm: FormGroup;
  accounts$: Observable<Account[]>;
  accountError$: Observable<string>;
  accountSuccess$: Observable<string>;
  isFormSubmitted: boolean = false;
  bankService: BankService;
  role: string | null;
  userId: string | null;
  errorMessage = '';
  successMessage = '';
  constructor(
    private formBuilder: FormBuilder,
    private banksService: BankService
  ) {
    // this.customers$ = this.banksService.getAllCustomers();
    // this.customers$.subscribe(data => {
    //   this.customers = data;
    // });

  }

  ngOnInit(): void {
    this.loadCustomers();
    this.accountForm = this.formBuilder.group({
      customer: [null, Validators.required], // ✅ Use null instead of empty string
      balance: ["", [Validators.required, Validators.min(0)]]
    });
  }

  loadCustomers(): void {
    this.banksService.getAllCustomers().subscribe({
      next: (response) => {
        this.customers = response;
      },
      error: (error) => console.log('Error in loading customers')
    })
  }

  onSubmit() {
    this.isFormSubmitted = true;
    this.accountSuccess$ = of('');
    this.accountError$ = of('');
    if (this.accountForm.invalid) {
      this.errorMessage = 'Please fill out all required fields correctly.';
      return;
    } else {
      const formData = this.accountForm.value;
      console.log(formData);
      const account = new Account(formData);
      this.banksService.addAccount(account).subscribe(
        (res: any) => {
          this.accountSuccess$ = of("Account created successfully");
          this.successMessage = "Account created successfully";
        },
        (error) => {
          this.accountError$ = of("Unable to create account");
          this.errorMessage = "Unable to create account";
        }
      );
    }
  }
}