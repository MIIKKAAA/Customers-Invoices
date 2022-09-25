package com.miikka.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.miikka.booking.model.Customer;
import com.miikka.booking.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public String viewHomePage(Model model) {
		model.addAttribute("listCustomers", customerService.getAllCustomers());
		return "customer_management";
	}
	
	@GetMapping("/customers/{id}")
	public String getCustomerById(@PathVariable (value = "id") long id, Model model) {
		Customer customer = customerService.getCustomerById(id);
		model.addAttribute("customer", customer);
		return "customer_info";
		
	}
	
	@GetMapping("/customers/newCustomerForm")
	public String newCustomerForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "new_customer";	
	}
	
	@PostMapping("/customers/saveCustomer")
	public String addCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/";
	}
	
	@GetMapping("/customers/showUpdateForm/{id}")
	public String showUpdateForm(@PathVariable (value = "id") long id, Model model) {
		
		Customer customer = customerService.getCustomerById(id);
		
		model.addAttribute("customer", customer);
		return "update_customer";
		
	}
	@GetMapping("/customers/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable (value="id") long id) {
		this.customerService.deleteCustomer(id);
		return "redirect:/";
	}
}
