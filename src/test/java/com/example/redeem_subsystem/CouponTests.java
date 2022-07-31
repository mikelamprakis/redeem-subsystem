package com.example.redeem_subsystem;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import com.example.redeem_subsystem.model.Coupon;
import com.example.redeem_subsystem.repository.CouponDao;



@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
class CouponTests {
	
	@Autowired
	private CouponDao couponDao;
	
	
	@Test
	void test_ifSaveNewCoupon_CouponExistInDatabase() {
		Coupon coupon = new Coupon();
		couponDao.save(coupon);
		assertNotNull(couponDao.findById(coupon.getId()));
	}
	
	@Test
	void test_IfFindUserById1_ReturnValue10() {
		Coupon coupon = couponDao.findById(1).get();
		assertTrue(coupon.getValue()==10);
	}
	

	@Test
	void test_IfFindUserById1_ReturnAvailableRedeems8() {
		Coupon coupon = couponDao.findById(1).get();
		assertTrue(coupon.getAvailableRedeems()==8);
	}
	
	@Test
	void test_IfsetAvailableRedeemsTo15_ReturnAvailableRedeems15() {
		Coupon coupon = couponDao.findById(1).get();
		coupon.setAvailableRedeems(15);
		couponDao.save(coupon);
		assertTrue(coupon.getAvailableRedeems()==15);
	}
	
	@Test
	void test_ifFindAllCouponsInDataBase_Return8Coupons() {
		assertTrue(couponDao.findAll().size()==8);
	}
	
	@Test
	void test_ifSaveNewCoupon_9CouponsExistInDatabase() {
		Coupon coupon = new Coupon();
		couponDao.save(coupon);
		assertTrue(couponDao.findAll().size()==9);
	}

	
	@Test
	void test_ifIRedeemCouponWithId1Once_ReturnAvailableRedeems7() {
		Coupon coupon = couponDao.findById(1).get();
		coupon.updateAvailableRedeems();
		couponDao.save(coupon);
		assertEquals(7,coupon.getAvailableRedeems());
	}
	
	@Test
	void test_ifIRedeemCouponWithId1Twice_ReturnAvailableRedeems6() {
		Coupon coupon = couponDao.findById(1).get();
		coupon.updateAvailableRedeems();
		coupon.updateAvailableRedeems();
		couponDao.save(coupon);
		assertEquals(6,coupon.getAvailableRedeems());
	}
	
	@Test
	void test_ifIDontRedeemCouponWithId1_checkRedeemAvailabilityReturnsTrue() {
		Coupon coupon = couponDao.findById(1).get();
		assertEquals(true,coupon.checkRedeemAvailability());
	}
	
	@Test
	void test_ifIRedeemCouponWithId1For8Times_checkRedeemAvailabilityReturnsFalse() {
		Coupon coupon = couponDao.findById(1).get();
		for (int i=0; i<8; i++) {
			coupon.updateAvailableRedeems();
		}
		assertEquals(false,coupon.checkRedeemAvailability());
	}
	
	@Test
	void test_ifIRedeemCouponWithId1For7Times_checkRedeemAvailabilityReturnsTrue() {
		Coupon coupon = couponDao.findById(1).get();
		for (int i=0; i<7; i++) {
			coupon.updateAvailableRedeems();
		}
		assertEquals(true,coupon.checkRedeemAvailability());
	}

}
