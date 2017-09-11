package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Dao.CustomerRepository;
import com.example.Model.Customer;

@SpringBootApplication
public class Application  //implements CommandLineRunner
{
	
	//@Autowired
	//private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/* @Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		repository.deleteAll();
		
		repository.save(new Customer("Alice","smith"));
		repository.save(new Customer("Bob","smith"));
		
		
		for(Customer customer:repository.findAll())
			System.out.println(customer);
		
		
		System.out.println(repository.findByFirstName("Alice"));
		
		
		for(Customer customer:repository.findByLastName("smith"))
			System.out.println(customer);
		
	} */
}
