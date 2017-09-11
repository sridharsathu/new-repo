package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.Dao.CustomerRepository;
import com.example.Model.Customer;
import com.example.service.CustomerService;

@RestController
public class TestController {
	
	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	private CustomerService customerService;

	
	@PostMapping("/create")
	public String Create(@ModelAttribute Customer customer)
	{
		
		String message=customerService.saveCustomerData(customer);
		if(message.equals("Success"))
			return customer.id+" Record inserted sucessfully";
		
			return customer.id+"  id already exist";
	}
	
	@RequestMapping("/")
	@ResponseBody
	public  String hello()
	{
		return "login";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam String id)
	{
		String message=customerService.deleteCustomerData(id);
		
		if(message.equals("Success"))
		return id+" deleted sucessfully";
		
		return id+" not Exist";
		
	}
	
	@PostMapping("/update")
	public String Update(@ModelAttribute Customer customer)
	{
		String message=customerService.updateCustomerData(customer);
		
		if(message.equals("Success"))
		return customer.id+" updated Successfully";
		else
			return customer.getId()+" not Exist";
	}
	@RequestMapping("/display")
	public ModelAndView dispalyAll()
	{
		// List<Customer> customerData=new ArrayList<Customer>();
		List<Customer> customerList=customerService.dispalyCustomerData();
		
		ModelAndView model=new ModelAndView("customers");
		model.addObject("customerData", customerList);
		
		// Map<List<Customer>, List<Customer>> model = new HashMap<List<Customer>, List<Customer>>();
		// model.put(customerData, customerList);
		 //System.out.println(customerList.size());
		
		return model;
	}
	
	
	
}
