package com.anbtech.anbframe.anbweb.usermng.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anbtech.anbframe.anbweb.usermng.service.UserMngService;
import com.anbtech.anbframe.anbweb.usermng.vo.UserMngVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserMngController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserMngController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	UserMngService userMngService;
	
	
	@RequestMapping(value = "/usermng/userMng", method = RequestMethod.GET)
	public String userMng(Locale locale, Model model) {
		logger.info("/usermng/userMng");
		
		UserMngVO param = new UserMngVO();
		//model.addAttribute("list", userMngService.getListUser(param).size());
		
		return "/usermng/userMng";
	}
	
	@ResponseBody
	@RequestMapping(value = "/userMng/getListUser", method = RequestMethod.POST)
	public List getListUser(@ModelAttribute UserMngVO param) {
		logger.info("/usermng/userMng");
		return userMngService.getListUser(param);
	}
	
	
	@RequestMapping(value = "/userMng/editUser", method = RequestMethod.POST)
	public void editUser(@ModelAttribute UserMngVO param) {
		
		
		

	}
	
}
