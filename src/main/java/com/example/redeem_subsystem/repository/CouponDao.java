package com.example.redeem_subsystem.repository;

import com.example.redeem_subsystem.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CouponDao extends JpaRepository<Coupon, Integer> {
	
	
}
