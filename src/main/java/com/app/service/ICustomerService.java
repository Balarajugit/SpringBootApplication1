package com.app.service;

import java.util.List;

import com.app.module.Customer;

public interface ICustomerService {
	
	public Integer saveById(Customer c);
	public List<Customer> getAppCustomers();
	public Customer getById(Integer custId);
	public void deleteById(Integer custId);

}
