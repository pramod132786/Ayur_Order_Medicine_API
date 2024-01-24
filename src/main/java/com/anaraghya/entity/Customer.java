package com.anaraghya.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_DTLS")
public class Customer {

	@Id
	@Column(name = "customer_Id")
	private Integer id;
	private String customerName;
	private String mobileNumber;
	private String emailId;
	private String password;

	@OneToMany(mappedBy = "customer")
	private List<Order> order;

	public List<Order> getOrders() {
		return order;
	}

	public void setOrders(List<Order> order) {
		this.order = order;
	}

	public Integer getCustomerId() {
		return id;
	}

	public void setCustomerId(Integer customerId) {
		this.id = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
