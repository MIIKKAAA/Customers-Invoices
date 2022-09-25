package com.miikka.booking.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bill")
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String receiver;
	private String bank_id;
	private String acc_num;
	private String due_date; //Testeja varten String, Date-implementaatio myohemmin
	private int ref_num;
	private String msg;
	private double amount;
	private String status;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
	
	public Bill() {
		
	}
	
	public Bill(Long id, String receiver, String bank_id, String acc_num, String due_date, int ref_num, String msg,
			double amount, String status, Customer customer) {
		super();
		this.id = id;
		this.receiver = receiver;
		this.bank_id = bank_id;
		this.acc_num = acc_num;
		this.due_date = due_date;
		this.ref_num = ref_num;
		this.msg = msg;
		this.amount = amount;
		this.status = status;
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getReceiver() {
		return receiver;
	}


	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}


	public String getBank_id() {
		return bank_id;
	}


	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}


	public String getAcc_num() {
		return acc_num;
	}


	public void setAcc_num(String acc_num) {
		this.acc_num = acc_num;
	}


	public String getDue_date() {
		return due_date;
	}


	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}


	public int getRef_num() {
		return ref_num;
	}


	public void setRef_num(int ref_num) {
		this.ref_num = ref_num;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
