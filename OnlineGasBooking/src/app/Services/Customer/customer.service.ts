import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Customer } from 'src/app/Models/Customer_Login';
import { Customer_Login } from 'src/app/Customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
 
  url: string = 'http://localhost:8000/GasBooking/Customer_Login';

  constructor(private http: HttpClient) { }

  addCustomer(customer: Customer_Login): Observable<any> {
    return this.http.post(`${this.url}/addCustomer`, customer);
  }

  getUserId(userName: string): Observable<any> {
    return this.http.get(`${this.url}/getUserId/${userName}`);
  }

  getCustomer(userId:number):Observable<any>{
    return this.http.get(`${this.url}/getCustomers/${userId}`)
  }

  customerLogin(credentials : any): Observable<any> {
    return this.http.post(`${this.url}/login`,credentials);
  }

}
