package com.example.Dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,String> {
	
	 public Customer findByFirstName(String firstName);
	 
	 public List<Customer> findByLastName(String lastName);
	  

}
