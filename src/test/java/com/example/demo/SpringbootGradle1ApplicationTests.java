package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.example.Dao.CustomerRepository;
import com.example.Model.Customer;
import com.example.service.CustomerService;
import com.example.service.CustomerServiceImpl;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class SpringbootGradle1ApplicationTests {
	
@InjectMocks
private CustomerServiceImpl customerServiceImpl;

@Mock
private CustomerRepository repository;

@InjectMocks
private TestController testController;

@Mock
private CustomerService customerService;

@Before
public void beforMethod()
{
	//System.out.println("before method");
	 
}


// Test cases for the deleting the customer
@Test
public void testDeleteCustomerDetails()
{

	System.out.println("delete customer details test method started");
	
	 Customer customer=new Customer();
	 customer.setId("101");
	 customer.setFirstName("sridhar");
	 customer.setLastName("sathu");
	 ArrayList<Customer> al=new ArrayList<Customer>();
	al.add(customer);	
	 when(repository.findAll()).thenReturn(al);
	String message=customerServiceImpl.deleteCustomerData("101");
	// System.out.println(result);
	assertEquals("Success",message);
	
}


//Testcases for the saving the customer Details


@Test
public void testSaveCustomerDetails()
{
	
	System.out.println("saving customer details test method started");
	ArrayList<Customer> al=new ArrayList<Customer>();
	
	Customer customer=new Customer();
	customer.setId("102");
	customer.setFirstName("Srikanth");
	customer.setLastName("sathu");
	
	al.add(customer);
	
	Customer customer1=new Customer();
	customer1.setId("103");
	customer1.setFirstName("sharath");
	customer1.setLastName("sathu");
	
	al.add(customer1);
	when(repository.findAll()).thenReturn(al);
	String message=customerServiceImpl.saveCustomerData(customer1);
	assertEquals("Success",message);
	
	
}

@Test
public void testDisplayAllCustomerDetails()
{
	System.out.println("display customer details test method started");
	ArrayList<Customer> al=new ArrayList<Customer>();
	
	Customer customer=new Customer();
	customer.setId("102");
	customer.setFirstName("Srikanth");
	customer.setLastName("sathu");
	al.add(customer);
	
	Customer customer1=new Customer();
	customer1.setId("103");
	customer1.setFirstName("sharath");
	customer1.setLastName("sathu");
	al.add(customer1);
	
	when(repository.findAll()).thenReturn(al);
	List<Customer> customerList=customerServiceImpl.dispalyCustomerData();
	System.out.println(customerList);
	assertEquals(2,customerList.size());
}

@Test
public void testUpdateCustomerDetails()
{
	System.out.println("update customer details test method started");
	ArrayList<Customer> al=new ArrayList<Customer>();
	Customer customer=new Customer();
	customer.setId("102");
	customer.setFirstName("Srikanth");
	customer.setLastName("sathu");
	al.add(customer);
	
	Customer customer1=new Customer();
	customer1.setId("103");
	customer1.setFirstName("sharath");
	customer1.setLastName("sathu");
	al.add(customer1);
	
	when(repository.findAll()).thenReturn(al);
	String message=customerServiceImpl.updateCustomerData(customer);
	assertEquals("Success",message);
	
}

@Test
public void testCreate()
{
	System.out.println("create customer details test method in Controller started");
	String info="Success";
	Customer customer=new Customer();
	customer.setId("102");
	customer.setFirstName("Srikanth");
	customer.setLastName("sathu");
	
	when(customerService.saveCustomerData(customer)).thenReturn(info);
	
	String message=testController.Create(customer);
	assertEquals("102 Record inserted sucessfully", message);
}

@Test
public void testDelete()
{
	System.out.println("delete customer details test method in Controller started");
	 String id="101"; 
	when(customerService.deleteCustomerData(id)).thenReturn("Success");
	String message=testController.delete("101");
	System.out.println(message);
	assertEquals(id+" deleted sucessfully", message);
}


@Test
public void testUpdate()
{
	System.out.println("update customer details test method in Controller started");
	String id="102";
	Customer customer=new Customer();
	customer.setId("102");
	customer.setFirstName("Srikanth");
	customer.setLastName("sathu");
	
	 when(customerService.updateCustomerData(customer)).thenReturn("Success");
	 String message=testController.Update(customer);
	 assertEquals(id+" updated Successfully", message);
	
}

@Test
public void testDisplay()
{
	System.out.println("display customer details test method in Controller started");
ArrayList<Customer> al=new ArrayList<Customer>();
	
	Customer customer=new Customer();
	customer.setId("102");
	customer.setFirstName("Srikanth");
	customer.setLastName("sathu");
	
	al.add(customer);
	
	Customer customer1=new Customer();
	customer1.setId("103");
	customer1.setFirstName("sharath");
	customer1.setLastName("sathu");
	
	al.add(customer1);
	
	when(customerService.dispalyCustomerData()).thenReturn(al);
	ModelAndView mav=  testController.dispalyAll();
	assertFalse(mav.isEmpty());
	System.out.println(mav);
	//assertEquals(al.size(), cusList.size());
	
	
	
}
}
