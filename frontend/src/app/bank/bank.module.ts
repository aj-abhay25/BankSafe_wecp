import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

import { BankRoutingModule } from "./bank-routing.module";
import { ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";

@NgModule({
  declarations: [],
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
