import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddCustomerComponent } from './Add-Customer/add-customer/add-customer.component';
import { CustomerComponent } from './Customer/customer/customer.component';
import { CustomerListComponent } from './Customer-List/customer-list/customer-list.component';
import { UpdateCustomerComponent } from './Update-Customer/update-customer/update-customer.component';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';



@NgModule({
  declarations: [
    AppComponent,
    AddCustomerComponent,
    CustomerComponent,
    CustomerListComponent,
    UpdateCustomerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
