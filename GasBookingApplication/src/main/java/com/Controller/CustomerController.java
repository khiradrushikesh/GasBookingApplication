package com.Controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Customer;
import com.service.CustomerService;

@RestController
@RequestMapping("/GasBooking")
@CrossOrigin
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	
	
//	@GetMapping("/signIn")
//	public Customer signInUser(@RequestBody String emailId, String password, int cid)  {
//		return CustomerService.signIn(emailId, password, cid);
//	}
	 
	
	
	
	  @GetMapping(path="/addData") 
	  public Customer customer() { 
		  Customer c = new Customer(); 
		  c.setCid(22); 
		  c.setCname("Rushi");
		  c.setUsername("Rushi123");
		  c.setEmailId("Rushi@gmail.com"); 
		  c.setPassword("Rushi@1234");
		  c.setCphoneno("9988998877"); 
		  c.setCaddress("Vedant nagar, Railway Station road"); 
		  c.setCustAccountNo(11223344);
		  c.setCustCylinderId(12321);
		  c.setCustIFSCcode("SBIN001100");
		  c.setCustPANno("ABCD321E");
		  c.setCustBankId(010203);
	  return c; }
	 
	 
	 
	 
	
	@PostMapping(path="/addCustomer")
	public ResponseEntity<Customer> addCustomer( @Valid @RequestBody Customer c)
	{
		Customer c1 = customerService.addCustomer(c);
		ResponseEntity<Customer> re = new ResponseEntity<Customer>(c1, HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getCustomers")
	public ResponseEntity<List<Customer>> getCustomers()
	{
		List<Customer> lc = customerService.getCustomer();
		ResponseEntity<List<Customer>> re = new ResponseEntity<List<Customer>>(lc, HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getCustomer/{cid}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int cid) throws Throwable
	{
		Customer c1 = customerService.getCustomerById(cid);
		ResponseEntity re = new ResponseEntity<Customer>(c1, HttpStatus.OK);
		return re;
	}	
	
		 
	  @PutMapping(path="/updateCustomer") 
	  public ResponseEntity<Customer>  updateCustomer(@Valid @RequestBody Customer e) throws Throwable
	  {
		  Customer e1=customerService.updateCustomer(e); 
		  ResponseEntity re=new ResponseEntity<Customer>(e1,HttpStatus.OK); 
		  return re; 
	}
	  
	  @DeleteMapping(path="/deleteCustomer") 
	  public ResponseEntity<String>  deleteCustomer(@RequestBody Customer e)
	  { 
		  customerService.deleteCustomer(e);
		  ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		  return re; 
	 }
	  
	  @DeleteMapping(path="/deleteCustomerById/{cid}") 
	  public ResponseEntity<String> deleteCustomerById(@PathVariable int cid) throws Throwable 
	  {
		  customerService.deleteCustomerById(cid); 
		  ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK); 
		  return re; 
	   }
		
		  @GetMapping("/getCustomername/{cname}") 
		  public ResponseEntity<Customer> getCustomerByCname(@PathVariable String cname) throws Throwable
		  {
			  Customer c=customerService.getCustomerByCname(cname); 
			  ResponseEntity re=new ResponseEntity<Customer>(c,HttpStatus.OK); 
			  return re; 
		}
		  
		 
		 	 
}
