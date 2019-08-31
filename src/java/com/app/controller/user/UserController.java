package com.app.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.service.user.UserServiceIF;
import com.common.collection.CommonVO;
import com.common.controller.BaseController;

@Controller
public class UserController extends BaseController {
	
	@Autowired
	UserServiceIF userService;
	
	@PostMapping("user/login")
	public ModelAndView home(@ModelAttribute("request") CommonVO param) throws Exception {
		ModelAndView mav = new ModelAndView("home");
		
		mav.addObject("response" , userService.registerUserIfNew(param));
		
		return mav;
	}
	
}