package com.miikka.booking.service;

import java.util.List;

import com.miikka.booking.model.Bill;

public interface BillService {

	List<Bill> getAllBills();
	void saveBill(Bill bill);
	Bill getBillById(long id);
	void deleteBill(long id);
}
