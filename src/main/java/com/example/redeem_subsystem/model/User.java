package com.example.redeem_subsystem.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
	@SequenceGenerator(name = "user_gen", sequenceName = "USER_SEQ", allocationSize = 1)
	private int id;
	
	private String firstname;
	private String lastname;
	
	@ManyToMany
	private List<Coupon> listOfCoupons = new ArrayList<>();
	
	public User(String firstname, String lastname, List<Coupon> listOfCoupons) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.listOfCoupons = listOfCoupons;
	}

	public User() {
		super();
	}
	
	public boolean checkIfValid(Optional<Coupon> currentCoupon) {
		boolean result = false ;
		for (Coupon coupon : getListOfCoupons()) {
			if (coupon.getId() == currentCoupon.get().getId()) {
				result = true;
				break;
			}else {
				result = false;
			}
		}	
		return result;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Coupon> getListOfCoupons() {
		return listOfCoupons;
	}

	public void setListOfCoupons(List<Coupon> listOfCoupons) {
		this.listOfCoupons = listOfCoupons;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", listOfCoupons="
				+ listOfCoupons + "]";
	}
}
