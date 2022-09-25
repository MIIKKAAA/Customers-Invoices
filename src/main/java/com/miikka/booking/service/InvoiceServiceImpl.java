package com.miikka.booking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miikka.booking.model.Invoice;
import com.miikka.booking.repository.InvoiceRepository;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Override
	public List<Invoice> getAllInvoices() {
		return this.invoiceRepository.findAll();
	}

	@Override
	public void saveInvoice(Invoice invoice) {
		this.invoiceRepository.save(invoice);
		
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

}
