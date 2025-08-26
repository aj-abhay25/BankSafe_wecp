import { NgModule } from "@angular/core";
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from "@angular/router";
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';

const routes: Routes = [
  {
    path: "auth",
    loadChildren: () => import("./auth/auth.module").then((m) => m.AuthModule),
  },

  {
    path: "bank",
    loadChildren: () => import("./bank/bank.module").then((m) => m.BankModule),
  },
  {
    path: "",
    pathMatch: "full",
    redirectTo: "/auth",
  },
];

@NgModule({
  declarations: [
    AppComponent // Declare AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  bootstrap: [AppComponent] // Bootstrap AppComponent
})
export class AppRoutingModule {}