package com.anaraghya.entity;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@Entity
//@Table(name = "medicine_Module")
public class MedicineModule {

	@Id
	private Integer medicineId;

//	public CartModuleEntity getCart() {
//		return cart;
//	}
//
//	public void setCart(CartModuleEntity cart) {
//		this.cart = cart;
//	}

	public Integer getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public Double getMedicineCost() {
		return medicineCost;
	}

	public void setMedicineCost(Double medicineCost) {
		this.medicineCost = medicineCost;
	}

	public LocalDate getMfd() {
		return mfd;
	}

	public void setMfd(LocalDate mfd) {
		this.mfd = mfd;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getMedicineCompany() {
		return medicineCompany;
	}

	public void setMedicineCompany(String medicineCompany) {
		this.medicineCompany = medicineCompany;
	}

	private String medicineName;
	private Double medicineCost;
	private LocalDate mfd;
	public Integer getMedicineQuantity() {
		return medicineQuantity;
	}

	public void setMedicineQuantity(Integer medicineQuantity) {
		this.medicineQuantity = medicineQuantity;
	}

	private LocalDate expiryDate;
	private String medicineCompany;
	private Integer medicineQuantity;
//
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "cart_id", nullable = false)
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	@JsonIgnore
//	private CartModuleEntity cart;
}
