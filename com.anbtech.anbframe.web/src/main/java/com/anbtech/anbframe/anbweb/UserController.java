package com.anbtech.anbframe.anbweb;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anbtech.anbframe.entities.AnbUser;
import com.anbtech.anbframe.persistance.service.UserService;

@Controller
public class UserController {

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService service;
	
	@ResponseBody
	@RequestMapping(value="/user_all", method=RequestMethod.GET)
	public List getUserAll() throws Exception{

		AnbUser entity = new AnbUser();
		entity.setUserName("테스");
		List list = service.selectUser(entity);

		return list;
	}
	
}
