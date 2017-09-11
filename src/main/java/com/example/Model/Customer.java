package com.example.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {
	
	@Id
	public String id;
	
	public String firstName;
	
	public String lastName;
	
	public Customer()
	{
		
	}
	public Customer( String firstName,String lastname )
	{
		this.firstName=firstName;
		this.lastName=lastName;
	}
   @Override
   public String toString() {
	// TODO Auto-generated method stub
		return  "FirstName"+firstName+""+"lastName"+lastName +"";
       }
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
   
   
	
}
