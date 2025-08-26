import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

import { AuthRoutingModule } from "./auth-routing.module";
import { ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    AuthRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  exports: [
    
  ]
})
export class AuthModule {}
