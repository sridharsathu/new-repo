package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Model.Customer;


public interface CustomerService {
	
	 public String saveCustomerData(Customer customer);
	 
	 public String deleteCustomerData(String id);
	 
	 public List<Customer> dispalyCustomerData();
	 
	 public String updateCustomerData(Customer customer);

}
