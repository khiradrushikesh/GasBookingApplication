import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/Services/Customer_Login.service';
import { Observable } from 'rxjs';
import { Customer_Login } from 'src/app/Customer';
import { error } from '@angular/compiler/src/util';



@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  customer_login:Customer_Login[]=[];
  dcustomers:Customer_Login[]=[];

  n:number=0;
  custs:Customer_Login=new Customer_Login(0,"","","","","","",0,0,0,"","");

  cust: Observable<Customer_Login[]> | undefined;
  dcust:Observable<Customer_Login> | undefined;
  Ucust:Observable<Customer_Login> | undefined;
  C_cust:Observable<Customer_Login> | undefined;
 
 

  constructor(private customerService:CustomerService) { }
  ngOnInit(): void {
    this.getCustomers();
  }
  getCustomers():void{  
    this.cust=this.customerService.getCustomers();
    this.cust.subscribe((data)=>this.customer_login=data);
  };
  
   deleteCustomer(customer:Customer_Login):void{
   /* this.dcust=this.customerService.deleteCustomer(customer_login); 
    this.dcust.subscribe(()=>this.getCustomers()); */
       document.write("Record is deleted");
       location.reload();
  }; 

createCustomer():void{
  this.C_cust=this.customerService.addCustomer(this.custs);
  this.C_cust.subscribe(data=>alert("Customer created successfully."));
    location.reload();
};  

updateEmployee():void{
  this.Ucust=this.customerService.updateCustomer(this.custs);
  this.Ucust.subscribe(data=>alert("Customer updated successfully."));
    location.reload();
   () => alert("Customer does not exist in the database cannot be updated");
};
}
