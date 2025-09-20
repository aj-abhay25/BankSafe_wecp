import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { TransactionComponent } from "./components/transaction/transaction.component";
import { DashboardComponent } from "./components/dashboard/dashboard.component";
import { CustomersComponent } from "./components/customer/customer.component";
import { AccountComponent } from "./components/account/account.component";
import { EditCustomerComponent } from "./components/customeredit/customeredit.component";
import { EditAccountComponent } from "./components/accountedit/accountedit.component";

const routes: Routes = [
  { path: "", component: DashboardComponent },
  { path: "customer", component: CustomersComponent },
  { path: "account", component: AccountComponent },
  { path: "transaction", component: TransactionComponent },
  { path: "customer/edit", component: EditCustomerComponent },
  { path: "account/edit", component: EditAccountComponent },
 
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class BankRoutingModule {}