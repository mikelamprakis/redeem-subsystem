package com.example.redeem_subsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
public class Coupon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coupon_gen")
	@SequenceGenerator(name = "coupon_gen", sequenceName = "COUPON_SEQ", allocationSize = 1)
	private int id;
	
	private double value;

	private int availableRedeems;

	public Coupon() {
		super();
	}

	public Coupon(double value, int availableRedeems) {
		super();
		this.value = value;
		this.availableRedeems = availableRedeems;
	}
	
	public boolean checkRedeemAvailability() {
		return availableRedeems>0 ;
	}

	public void updateAvailableRedeems() {
		availableRedeems -=1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getAvailableRedeems() {
		return availableRedeems;
	}

	public void setAvailableRedeems(int availableRedeems) {
		this.availableRedeems = availableRedeems;
	}

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", value=" + value + ", availableRedeems=" + availableRedeems + "]";
	}
}
