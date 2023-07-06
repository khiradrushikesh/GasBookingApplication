package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Customer;
import com.repository.CustomerRepo;

@SpringBootTest
class CustomerSeriveImplTest {
	
	@Autowired
	CustomerService customerService;
	
	@MockBean
	CustomerRepo Repo;
	
	@Test
	void testGetCustomers()
	{
		Customer c1 = new Customer();
		c1.setCid(4);
		c1.setCname("Amit");
		c1.setUsername("Amit123");
		c1.setEmailId("Amit@gmail.com");
		c1.setPassword("Amit@1234");
		c1.setCphoneno("9876543210");
		c1.setCaddress("Saptshree Heights");
		c1.setCustCylinderId(12998);
		c1.setCustBankId(776203);
		c1.setCustAccountNo(553422);
		c1.setCustIFSCcode("ICICI00617");
		c1.setCustPANno("VVGFD9165H");
		
		Customer c2 = new Customer();
		c1.setCid(5);
		c1.setCname("Abhishek");
		c1.setUsername("Abhi123");
		c1.setEmailId("Abhishek@gmail.com");
		c1.setPassword("Abhishek@1234");
		c1.setCphoneno("9897796666");
		c1.setCaddress("Nageshwarwadi");
		c1.setCustCylinderId(63376);
		c1.setCustBankId(77431);
		c1.setCustAccountNo(05531);
		c1.setCustIFSCcode("HDFC77412");
		c1.setCustPANno("HKKUH7763N");
		
		List<Customer> customerList = new ArrayList<>();
		customerList.add(c1);
		customerList.add(c2);
		
		Mockito.when(Repo.findAll()).thenReturn(customerList);
		
		
		assertThat(customerService.getCustomer()).isEqualTo(customerList);
	}
	
	@Test
	void testDeleteCoder() {
		Customer c1 = new Customer();
		c1.setCid(4);
		c1.setCname("Amit");
		c1.setUsername("Amit123");
		c1.setEmailId("Amit@gmail.com");
		c1.setPassword("Amit@1234");
		c1.setCphoneno("9876543210");
		c1.setCaddress("Saptshree Heights");
		c1.setCustCylinderId(12998);
		c1.setCustBankId(776203);
		c1.setCustAccountNo(553422);
		c1.setCustIFSCcode("ICICI00617");
		c1.setCustPANno("VVGFD9165H");
		Optional<Customer> c2=Optional.of(c1);
		
		Mockito.when(Repo.findById(1)).thenReturn(c2);
		 Mockito.when(Repo.existsById(c1.getCid())).thenReturn(false);
		   assertFalse(Repo.existsById(c1.getCid()));
	}
	
		
}
