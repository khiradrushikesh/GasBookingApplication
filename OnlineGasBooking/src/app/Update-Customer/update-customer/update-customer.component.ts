import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Customer_Login } from 'src/app/Customer';
import { CustomerService } from 'src/app/Services/Customer_Login.service';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {

  id: number | undefined;
  customer_Login!: Customer_Login ;
  Ucust: Observable<Customer_Login> | undefined;
  cid!: string;

  constructor(private route: ActivatedRoute,private router: Router,
    private customerService: CustomerService) { }

  ngOnInit(): void {
    this.cid = this.route.snapshot.params['id'];
    this.id=Number.parseInt(this.cid);
    this.customer_Login =new Customer_Login(this.id,"","","","","","",0,0,0,"","");
    console.log(this.id);
    this.customerService.getCustomerById(this.id).subscribe(data => {
      console.log(data)
      this.customer_Login=data;
    }, error => console.log(error));
  }

  onSubmit() {
    this.Ucust=this.customerService.updateCustomer(this.customer_Login);
  this.Ucust.subscribe(data=>{alert("Customer updated successfully.");},
  error => alert("Customer does not exist in the database cannot be updated"));
  this.router.navigate(['/customers']);
  }
  list(){
    this.router.navigate(['customers']);
  }
}
