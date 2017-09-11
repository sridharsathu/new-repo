package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dao.CustomerRepository;
import com.example.Model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository repository;
	/** Example code for mockito test cases
	String id;
	public CustomerServiceImpl(String id)
	{
		this.id=id;
	}
*/
	@Override
	public String saveCustomerData(Customer customer) {
		
		 boolean duplicate=false;
		 
	       customer.setFirstName(customer.getFirstName());
			customer.setLastName(customer.getLastName());
			customer.setId(customer.getId());
			 
			for(Customer customer1:repository.findAll() )
			{
				if(customer.getId().equals(customer1.getId()))
				{
					duplicate=true;
					
				}
		
			}
			System.out.println(duplicate);
			 if(duplicate==false)
			 {
			    repository.save(customer);
			     return "Success";
			 }
			 
		return "failure";
		// TODO Auto-generated method stub
		
	}

	@Override
	public String deleteCustomerData(String id) {
		
		 boolean duplicate=false;
		
		for(Customer customer1:repository.findAll() )
		{
			if(id.equals(customer1.getId()))
			{
				duplicate=true;
				
			}
	
		}
		 if(duplicate==true)
		 {
			 repository.delete(id);
		     return "Success";
		 }else
		 {
			 
		return "failure";
		 }
	}

	@Override
	public List<Customer> dispalyCustomerData() {
		
		return (repository.findAll());
	}

	@Override
	public String updateCustomerData(Customer customer) {
		boolean duplicate=false;
		
		for(Customer customer1:repository.findAll() )
		{
			if(customer.getId().equals(customer1.getId()))
			{
				duplicate=true;
				
			}
	
		}
	
		 if(duplicate==true)
		 {
		    repository.save(customer);
		     return "Success";
		 }
		 
		return "Faliure";
	}

}
