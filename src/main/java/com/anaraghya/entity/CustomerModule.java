package com.anaraghya.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "customer_module")
public class CustomerModule {

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

	public Long getMoblieNo() {
		return moblieNo;
	}

	public void setMoblieNo(Long moblieNo) {
		this.moblieNo = moblieNo;
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

	@Id
	@Column(name = "customer_Id")
	private Integer id;
	private String customerName;
	private Long moblieNo;
	private String emailId;
	private String password;
}
