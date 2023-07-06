import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/Services/Customer_Login.service';
import { Observable } from 'rxjs';
import { Customer_Login } from 'src/app/Customer';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customer_login:Customer_Login[]=[];
  dcustomers:Customer_Login[]=[];

  custs:Customer_Login=new Customer_Login(0,"","","","","","",0,0,0,"","");

  cust: Observable<Customer_Login[]> | undefined;
  dcust:Observable<Customer_Login> | undefined;
  Ucust:Observable<Customer_Login> | undefined;

  constructor(private customerService:CustomerService, private router:Router) { }

  ngOnInit(): void {
    this.cust=this.customerService.getCustomers();
      this.cust.subscribe((data)=>this.customer_login=data);
  }

  deleteCustomer(cid:number):void{
    this.dcust=this.customerService.deleteCustomer(cid);
    alert("Customer deleted Successfully");
    location.reload();
    this.dcust.subscribe(()=>this.customerService.getCustomers()); 
  }

  updateCustomer(id:number):void{
    this.router.navigate(['update',id]);
}
}
