package com.miikka.booking.service;

import java.util.List;

import com.miikka.booking.model.Invoice;

public interface InvoiceService {

	List<Invoice> getAllInvoices();
	void saveInvoice(Invoice invoice);
	Invoice getInvoiceById(long id);
	void deleteInvoice(long id);
}
