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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anbtech.anbframe.entities.AnbUser;
import com.anbtech.anbframe.persistance.service.UserService;

@Controller
public class UserController {

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService service;
	
	@ResponseBody
	@RequestMapping(value="/user_all", method=RequestMethod.POST)
	public List getUserAll() throws Exception{

		List list = service.selectUser(new AnbUser());

		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="/user_all_g", method=RequestMethod.GET)
	public List getUserAllGET() throws Exception{

		List list = service.selectUser(new AnbUser());

		return list;
	}
	
	
	@RequestMapping(value="/home_sjh", method=RequestMethod.GET)
	public String getSJH() throws Exception{
		
		return "test_sjh";
	}
	

	@RequestMapping(value="/home_kys", method=RequestMethod.GET)
	public String getKYS() throws Exception{
		
		return "test_kys";
	}
	
	
	@RequestMapping(value="/home_khj", method=RequestMethod.GET)
	public String getKHJ() throws Exception{
		
		return "test_khj";
	}
	
	
	@RequestMapping(value="/user_insert_sjh", method=RequestMethod.POST)
	public void insertUserSJH(@RequestParam(value="userId") String userId,@RequestParam(value="userName") String userName,
			@RequestParam(value="userGender") String userGender,@RequestParam(value="userBirth") String userBirth) throws Exception{
	
		LOG.info("{}", userId +" || "+userName+" || "+userGender+" || "+userBirth);
		AnbUser vo = new AnbUser();
		vo.setUserId(userId);
		vo.setUserName(userName);
		vo.setUserGender(userGender);
		String birth = "19700101";
		if(userBirth!=null){
			birth = userBirth;
		}
		
		vo.setUserBirth(null);
		
		service.saveOrUpdateUser(vo);	
	}
	
	@ResponseBody
	@RequestMapping(value="/user_delete_sjh", method=RequestMethod.POST)
	public Map deleteUserSJH(@RequestParam(value="userId")String userId) throws Exception {
		Map<String,String> map = new HashMap<String,String>();
		AnbUser vo = new AnbUser();
		vo.setUserId(userId);
		service.removeUser(vo);
		
		map.put("success", "성공적으로 삭제되었습니다.");
		
		return map;
	}
}
