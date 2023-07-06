package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>

	{
	Customer findByCname(String cname);
	
	
	
}
