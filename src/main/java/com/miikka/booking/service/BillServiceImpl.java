package com.miikka.booking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miikka.booking.model.Bill;
import com.miikka.booking.repository.BillRepository;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	BillRepository billRepository;
	
	@Override
	public List<Bill> getAllBills() {
		return this.billRepository.findAll();
	}

	@Override
	public void saveBill(Bill bill) {
		this.billRepository.save(bill);
		
	}

	@Override
	public Bill getBillById(long id) {
		Optional<Bill> optional = billRepository.findById(id);
		Bill bill = null;
		
		if(optional.isPresent()) {
			bill = optional.get();
		}
		else {
			throw new RuntimeException("Bill "+ id +" not found.");
		}
		return bill;
	}

	@Override
	public void deleteBill(long id) {
		this.billRepository.deleteById(id);
		
	}

}
