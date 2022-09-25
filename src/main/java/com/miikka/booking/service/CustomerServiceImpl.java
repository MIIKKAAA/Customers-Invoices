package com.miikka.booking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miikka.booking.model.Invoice;
import com.miikka.booking.model.Customer;
import com.miikka.booking.repository.InvoiceRepository;
import com.miikka.booking.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public void saveCustomer(Customer customer) {
		this.customerRepository.save(customer);
		
	}

	@Override
	public Customer getCustomerById(long id) {
		Optional<Customer> optional = customerRepository.findById(id);
		Customer customer = null;
		
		if(optional.isPresent()) {
			customer = optional.get();
		}
		else {
			throw new RuntimeException("Customer "+ id +" not found.");
		}
		return customer;
	}

	@Override
	public void deleteCustomer(long id) {
		this.customerRepository.deleteById(id);
		
	}

	@Override
	public void saveInvoice(Invoice invoice) {
		invoiceRepository.save(invoice);
		
	}
	
	@Override
	public List<Invoice> getAllInvoices() {
		return this.invoiceRepository.findAll();
	}

	@Override
	public Invoice getInvoiceById(long id) {
		Optional<Invoice> optional = invoiceRepository.findById(id);
		Invoice invoice = null;
		
		if(optional.isPresent()) {
			invoice = optional.get();
		}
		else {
			throw new RuntimeException("Invoice "+ id +" not found.");
		}
		return invoice;
	}

	@Override
	public void deleteInvoice(long id) {
		this.invoiceRepository.deleteById(id);
		
	}

	@Override
	public Customer getCustomerByIdWithInvoices(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
