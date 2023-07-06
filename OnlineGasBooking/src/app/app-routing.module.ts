import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UpdateCustomerComponent } from './Update-Customer/update-customer/update-customer.component';
import { CustomerComponent } from './Customer/customer/customer.component';
import { AddCustomerComponent } from './Add-Customer/add-customer/add-customer.component';
import { CustomerListComponent } from './Customer-List/customer-list/customer-list.component';

 const routes: Routes = [
   { path: '', redirectTo: 'customers', pathMatch: 'full' },
   { path: 'add', component: AddCustomerComponent },
   { path: 'customers', component: CustomerListComponent },
   { path: 'update/:id', component: UpdateCustomerComponent },
 ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
