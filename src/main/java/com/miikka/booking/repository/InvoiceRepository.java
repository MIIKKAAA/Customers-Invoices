package com.miikka.booking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miikka.booking.model.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
	List<Invoice> findByCustomerId(long customerId);
	
}
