package com.app.controller.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.app.service.common.CommonServiceIF;
import com.common.collection.CommonVO;
import com.common.controller.BaseController;

@Controller
public class HomeController extends BaseController {
	
	@Autowired
	CommonServiceIF service;
	
	@GetMapping("index")
	public ModelAndView home(@ModelAttribute("request") CommonVO param) {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("request" , param);
		
		return mav;
	}
	
}