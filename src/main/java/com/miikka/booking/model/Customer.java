package com.miikka.booking.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="customer_id")
		private long id;
		
		private String first_name;
		
		private String last_name;
		
		private String address;
		
		private int zip_code;
		
		private String email;
	    
		@OneToMany(mappedBy="customer")
		private List<Bill> bills;
		
	    public Customer() {
	    	
	    }
		
		public Customer(long id, String first_name, String last_name, String address, int zip_code, String email,
				List<Bill> bills) {
			super();
			this.id = id;
			this.first_name = first_name;
			this.last_name = last_name;
			this.address = address;
			this.zip_code = zip_code;
			this.email = email;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getFirst_name() {
			return first_name;
		}

		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}

		public String getLast_name() {
			return last_name;
		}

		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public int getZip_code() {
			return zip_code;
		}

		public void setZip(int zip_code) {
			this.zip_code = zip_code;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public List<Bill> getBills() {
			return bills;
		}

		public void setBills(List<Bill> bills) {
			this.bills = bills;
		}

		public void setZip_code(int zip_code) {
			this.zip_code = zip_code;
		}
		
	}

	
