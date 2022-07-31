package com.example.redeem_subsystem.model;

public class Availability {
	
	private int userId; 
	private int couponId;

	public Availability() {
		super();
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCouponId() {
		return couponId;
	}
	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}
}
