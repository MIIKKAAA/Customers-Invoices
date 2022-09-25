package com.miikka.booking.service;

import java.util.List;

import com.miikka.booking.model.Invoice;
import com.miikka.booking.model.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();
	void saveCustomer(Customer customer);
	Customer getCustomerById(long id);
	void deleteCustomer(long id);
	Customer getCustomerByIdWithInvoices(long id);
	List<Invoice> getAllInvoices();
	void saveInvoice(Invoice invoice);
	Invoice getInvoiceById(long id);
	void deleteInvoice(long id);
	
}
