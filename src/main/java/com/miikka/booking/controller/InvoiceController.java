package com.miikka.booking.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.miikka.booking.model.Invoice;
import com.miikka.booking.model.Customer;
import com.miikka.booking.repository.InvoiceRepository;
import com.miikka.booking.repository.CustomerRepository;
import com.miikka.booking.service.InvoiceService;
import com.miikka.booking.service.CustomerService;

@Controller
public class InvoiceController {

	protected Customer customerTmp;
	
	@Autowired
	InvoiceService invoiceService;
	
	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping("/invoices/{customerId}")
	public String getInvoicesByCustomerId(@PathVariable(value="customerId") long customerId, Model model, Model modelC){
		modelC.addAttribute("customer", customerService.getCustomerById(customerId));
		model.addAttribute("invoices", invoiceRepository.findByCustomerId(customerId));
		return "invoice_archive"; 
	}

	@GetMapping("/invoices/newInvoice/{customerId}")
	public String newInvoiceForm(@PathVariable(value="customerId") long customerId, Map<String, Object> model) {
		
		customerTmp = customerService.getCustomerById(customerId);	
		Invoice invoice = new Invoice();
		invoice.setCustomer(customerTmp);
		model.put("invoice", invoice);
		return "new_invoice";
	}
	
	
	@PostMapping("/invoices/newInvoice")
	public String saveInvoice(@ModelAttribute("invoice") Invoice invoice) {
		invoice.setCustomer(customerTmp);
		invoiceService.saveInvoice(invoice);
		return "redirect:/";
	}
	
	@GetMapping("/invoices/showUpdateForm/{id}")
	public String showUpdateForm(@PathVariable (value = "id") long id, Model model) {
		
		Invoice invoice = invoiceService.getInvoiceById(id);
		customerTmp = invoice.getCustomer();
		
		model.addAttribute("invoice", invoice);
		return "update_invoice";
	}
	
	@GetMapping("/invoices/deleteInvoice/{id}")
	public String deleteInvoice(@PathVariable (value="id") long id) {
		invoiceService.deleteInvoice(id);
		return "redirect:/";
	}
	
}
