package com.miikka.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.miikka.booking.model.Bill;
import com.miikka.booking.model.Customer;
import com.miikka.booking.repository.BillRepository;
import com.miikka.booking.repository.CustomerRepository;
import com.miikka.booking.service.BillService;
import com.miikka.booking.service.CustomerService;

@Controller
public class BillController {

	
	@Autowired
	BillService billService;
	
	@Autowired
	BillRepository billRepository;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping("/bills/{customerId}")
	public String getBillsByCustomerId(@PathVariable(value="customerId") long customerId, Model model, Model modelC){
		modelC.addAttribute("customer", customerService.getCustomerById(customerId));
		model.addAttribute("bills", billRepository.findByCustomerId(customerId));
		return "bill_archive"; 
		
		/*
		 * 	@GetMapping("/showUpdateForm/{id}")
	public String showUpdateForm(@PathVariable (value = "id") long id, Model model) {
		
		Customer customer = customerService.getCustomerById(id);
		
		model.addAttribute("customer", customer);
		return "update_customer";*/
	}
	
	@GetMapping("/bills/newBill")
	public String newBillForm(Model model) {
		Bill bill = new Bill();
		model.addAttribute("bill", bill);
		return "new_bill";
	}
	
	@PostMapping("/bills/saveBill")
	public String saveBill(@ModelAttribute("bill") Bill bill) {
		Customer customer = new Customer();
		billService.saveBill(bill);
		return "redirect:/";
	}
	
	@GetMapping("/bills/deleteBill/{id}")
	public String deleteBill(@PathVariable (value="id") long id) {
		billService.deleteBill(id);
		return "redirect:/";
	}
	
}
