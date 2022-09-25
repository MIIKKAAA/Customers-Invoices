package com.miikka.booking.service;

import java.util.List;
import com.miikka.booking.model.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();
	void saveCustomer(Customer customer);
	Customer getCustomerById(long id);
	void deleteCustomer(long id);
	
}
