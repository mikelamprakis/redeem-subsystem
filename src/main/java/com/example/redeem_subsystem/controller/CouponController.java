package com.example.redeem_subsystem.controller;
import java.util.Optional;

import com.example.redeem_subsystem.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.redeem_subsystem.model.Availability;
import com.example.redeem_subsystem.model.Coupon;
import com.example.redeem_subsystem.model.User;
import com.example.redeem_subsystem.repository.CouponDao;


@Controller
public class CouponController {
	
	@Autowired
	private CouponDao couponDao;
	
	@Autowired
	private UserDao userDao;
	
	@GetMapping("open-subsystem")
	public ModelAndView openSubSystem() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("availability", new Availability());
		mv.setViewName("WEB-INF/subsystemForm.jsp");
		return mv;
	}
	
	
	@PostMapping("submit-query")
	public ModelAndView submitQuery(
			@ModelAttribute("availability")Availability availability
			) {
		ModelAndView mv = new ModelAndView();
		Optional<User>  currentUser = userDao.findById(availability.getUserId());
		Optional<Coupon> currentCoupon = couponDao.findById(availability.getCouponId());
		
		if (currentUser.isPresent() && currentCoupon.isPresent()) {
				if (currentUser.get().checkIfValid(currentCoupon)) {
					if (currentCoupon.get().checkRedeemAvailability()) {
						currentCoupon.get().updateAvailableRedeems();
						couponDao.save(currentCoupon.get());
						mv.addObject("message", "Ticket redeemed successfully");
						mv.addObject("redeemsAvailable", "Redeems available for this coupon : ");
						mv.addObject("redeems", currentCoupon.get().getAvailableRedeems());
					}else {
						mv.addObject("message", "Number of maximum redeems reached. Please use another ticket");
					}
				}else {
					mv.addObject("message", "This ticket is not valid for this user");
				}
		}else {
			mv.addObject("message", "Invalid ticket or user id");
		}
		mv.setViewName("WEB-INF/subsystemForm.jsp");
		return mv;
	}
}
