import { Injectable } from "@angular/core";
import { HttpClient} from '@angular/common/http';
import { Observable } from "rxjs";
import { Customer_Login } from "../Customer";
@Injectable({
    providedIn: 'root'
  })

  export class CustomerService {
    customer_Login: Customer_Login | undefined; 
    constructor(
      private httpClient:HttpClient
    ) { }
  
        private baseUrl = "http://localhost:8000/GasBooking/";

        public getCustomers():Observable<Customer_Login[]> {
            return this.httpClient.get<Customer_Login[]>("http://localhost:8000/GasBooking/getCustomers");
        }

              
        public getCustomerById(cid:number):Observable<Customer_Login> {
          return this.httpClient.get<Customer_Login>(`${this.baseUrl}getCustomer`+cid);
        }
      
        public deleteCustomer(cid:number):Observable<Customer_Login> {
          return this.httpClient.delete<Customer_Login>(`${this.baseUrl}deleteCustomerById/`+cid);
        }
      
        public updateCustomer(customer_Login:Customer_Login):Observable<Customer_Login> {
          return this.httpClient.put<Customer_Login>(`${this.baseUrl}updateCustomer/`,customer_Login);
        }
      
        public addCustomer(customer_Login:Customer_Login):Observable<Customer_Login> {
          return this.httpClient.post<Customer_Login>(`${this.baseUrl}addCustomer/`,customer_Login);
        }
      }
      