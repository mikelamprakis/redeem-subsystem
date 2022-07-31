package com.example.redeem_subsystem.controller;
import com.example.redeem_subsystem.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.redeem_subsystem.model.User;

@Controller
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@GetMapping("user-login")
	public ModelAndView openUserLogin(
			) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("user",new User());
		mv.setViewName("login.jsp");
		return mv;
	}

	@RequestMapping("loginSubmit")
	public ModelAndView openDashboard(
			@ModelAttribute("user")User user
			) {
		ModelAndView mv = new ModelAndView();
		User userFromDB = userDao.findByFirstnameAndLastname(user.getFirstname(), user.getLastname());
		if (userFromDB == null) {
			mv.addObject("massage", "Incorrect login details");
			mv.setViewName("login.jsp");
		}else {
			mv.addObject("allCoupons", userFromDB.getListOfCoupons());
			mv.setViewName("WEB-INF/allCoupons.jsp");
		}
		return mv;		
	}
}
