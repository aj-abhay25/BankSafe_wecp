import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable, of } from 'rxjs';
import { Customer } from '../../types/Customer';
import { BankService } from '../../services/bank.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.scss']
})
export class CustomersComponent implements OnInit {

  customerForm !: FormGroup;
  customerError$: Observable<string>;
  customerSuccess$: Observable<string>;
  isFormSubmitted: boolean = false;
  customerError: string = '';
  customerSuccess: string = '';
  customer: Customer | null = null;

  constructor(
    private formBuilder: FormBuilder,
    private banksService: BankService
  ) { }

  ngOnInit(): void {
    this.customerForm = this.formBuilder.group({
      name: ["", [Validators.required]],
      email: ["", [Validators.required]],
      username: ["", [Validators.required, this.noSpecialCharacters]],
      password: ["", [Validators.required, Validators.minLength(8)]],
      role: ["USER", [Validators.required]]
    });
  }
  private noSpecialCharacters(control: any): {[key:string]: boolean} | null{
    const specialCharactersRegex = /[!@#$%^&*()_+{}\[\]:;<>,.?~\\/-]/;
    if(specialCharactersRegex.test(control.value)){
      return {specialCharacters : true}
    }
    return null
  }
  onSubmit() {
    this.isFormSubmitted = true;
    this.customerSuccess$ = of('');
    this.customerError$ = of('');
    const emailRegex: RegExp = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    if (this.customerForm.invalid) {
      this.customerError = "Please fill out all required fields correctly.";
      return;
    } else {

      const data = this.customerForm.value;
      if (data.password.length < 8) {
        this.customerError$ = of("Password must be of 8 characters");
        this.customerError = "Password must be of 8 characters";
        return;
      }
      if (this.noSpecialCharacters(data.username)) {
        this.customerError$ = of("User Name must consist of letter and number only!!");
        this.customerError = "User Name must consist of letter and number only!!";
        return;
      }
      console.log(emailRegex.test(data.email));
      if (!emailRegex.test(data.email)) {
        this.customerError$ = of("Invalid Email Id!!");
        this.customerError = "Invalid Email Id!!";
        return;

      }
      // const username = name, password = "abcd1234";
      const customer: Customer =
        new Customer(data);

      ;
      this.banksService.addCustomer(customer).subscribe(
        (res: any) => {
          this.customerSuccess$ = of('Customer created successfully');
          this.customerSuccess = "Customer created successfully";
        },
        (error) => {
          this.customerError$ = of("Unable to create customer");
          this.customerError = "Unable to create customer";
        }
      );
    }
  }
}