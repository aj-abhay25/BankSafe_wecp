import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

import { BankRoutingModule } from "./bank-routing.module";
import { ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { AccountComponent } from "./components/account/account.component";
import { CustomersComponent } from "./components/customer/customer.component";

@NgModule({
  declarations: [
    AccountComponent,
    CustomersComponent
  ],
  schemas: [NO_ERRORS_SCHEMA],
  imports: [
    CommonModule,
    BankRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  exports: [
  ]
})
export class BankModule {}