import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Customer_Login } from 'src/app/Customer';
import { CustomerService } from 'src/app/Services/Customer_Login.service';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
  export class AddCustomerComponent implements OnInit {

    customer_Login:Customer_Login=new Customer_Login(0,"","","","","","",0,0,0,"","");
    acust:Observable<Customer_Login> | undefined;
    submitted=false;
    msg="";

  constructor(private customerService:CustomerService,private router:Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.submitted = true;
      this.acust=this.customerService.addCustomer(this.customer_Login);
      this.acust.subscribe(Data=>alert("Customer created successfully."));     
    this.router.navigate(['/customers']);
}

}
