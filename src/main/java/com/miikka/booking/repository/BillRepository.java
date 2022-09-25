package com.miikka.booking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miikka.booking.model.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
	List<Bill> findByCustomerId(long customerId);
	
}
