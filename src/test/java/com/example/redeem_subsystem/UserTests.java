package com.example.redeem_subsystem;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.redeem_subsystem.model.Coupon;
import com.example.redeem_subsystem.model.User;
import com.example.redeem_subsystem.repository.CouponDao;
import com.example.redeem_subsystem.repository.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;


@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
class UserTests {
	
	@Autowired
	private CouponDao couponDao;
	
	@Autowired
	private UserDao userDao;

	@Test
	void test_ifSaveNewUser_UserExistInDatabase() {
		User user = new User();
		userDao.save(user);
		assertNotNull(userDao.findById(user.getId()));
	}
	
	@Test
	void test_IfFindUserById1_ReturnFirstNameMike() {
		User user = userDao.findById(1).get();
		assertTrue(user.getFirstname().equals("Mike"));
	}
	

	@Test
	void test_IfFindUserById1_ReturnLastNameLamprakis() {
		User user = userDao.findById(1).get();
		assertTrue(user.getLastname().equals("Lamprakis"));
	}
	
	@Test
	void test_IfCreateNewUserAndAddOneCoupon_Return1CouponInListOfCoupons() {
		User user = new User();
		List<Coupon> list = new ArrayList<>();
		user.setListOfCoupons(list);
		Coupon coupon = new Coupon();
		couponDao.save(coupon);
		user.getListOfCoupons().add(coupon);
		userDao.save(user);
		assertTrue(user.getListOfCoupons().size()==1);
	}
	
	@Test
	void test_ifFindAllUsersInDataBase_Return2User2() {
		assertTrue(userDao.findAll().size()==2);
	}
	
	@Test
	void test_ifSaveNewUser_3UserExistInDatabase() {
		User user = new User();
		userDao.save(user);
		assertTrue(userDao.findAll().size()==3);
	}
	
	
	@Test
	void test_ifIAddOnlyCouponInListOfCoupons_checkValidForCoupon2ReturnsFalse() {
		Optional<User> user = Optional.of(new User());
		List<Coupon> list = new ArrayList<>();
		user.get().setListOfCoupons(list);
		Optional<Coupon> coupon = Optional.of(new Coupon());
		Optional<Coupon> coupon2 = Optional.of(new Coupon());
		couponDao.save(coupon.get());
		couponDao.save(coupon2.get());
		user.get().getListOfCoupons().add(coupon.get());
		userDao.save(user.get());
		assertEquals(false, user.get().checkIfValid(coupon2));
	}
	
	
	@Test
	void test_ifIAddOnlyCoupon2InListOfCoupons_checkValidForCoupon2ReturnsTrue() {
		Optional<User> user = Optional.of(new User());
		List<Coupon> list = new ArrayList<>();
		user.get().setListOfCoupons(list);
		Optional<Coupon> coupon = Optional.of(new Coupon());
		Optional<Coupon> coupon2 = Optional.of(new Coupon());
		couponDao.save(coupon.get());
		couponDao.save(coupon2.get());
		user.get().getListOfCoupons().add(coupon2.get());
		userDao.save(user.get());
		assertEquals(true, user.get().checkIfValid(coupon2));
	}

}
