package com.anbtech.anbframe.anbweb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	@ResponseBody
	@RequestMapping(value="/user_insert_sjh", method=RequestMethod.POST)
	public Map insertUserSJH(@RequestParam(value="userId") String userId,@RequestParam(value="userName") String userName,
			@RequestParam(value="userGender") String userGender,@RequestParam(value="userBirth") String userBirth) {
	
		Map<String,String> map = new HashMap<String,String>();
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
		
		
		String msg = "";
		String key = "";
		try{
			service.saveOrUpdateUser(vo);
			msg = "성공적으로 등록되었습니다.";
			key = "success";
		}catch(Exception e){
			msg = e.getLocalizedMessage();
			key = "error";
		}
		
		map.put(key, msg);
		
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="/user_delete_sjh", method=RequestMethod.POST)
	public Map deleteUserSJH(@RequestParam(value="userId")String userId) {
		Map<String,String> map = new HashMap<String,String>();
		AnbUser vo = new AnbUser();
		vo.setUserId(userId);
		String msg = "";
		String key = "";
		try{
			service.removeUser(vo);
			msg = "성공적으로 삭제되었습니다.";
			key = "success";
		}catch(Exception e){
			msg = e.getLocalizedMessage();
			key = "error";
		}
		
		map.put(key, msg);
		
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="/user_insert_kys", method=RequestMethod.POST)
	public Map insertUserKYS(@RequestParam(value="userId") String userId,@RequestParam(value="userName") String userName,
			@RequestParam(value="userGender") String userGender,@RequestParam(value="userBirth") String userBirth) {
	
		Map<String,String> map = new HashMap<String,String>();
		LOG.info("{}", userId +" || "+userName+" || "+userGender+" || "+userBirth);
		AnbUser vo = new AnbUser();
		vo.setUserId(userId);
		vo.setUserName(userName);
		vo.setUserGender(userGender);
		
//		String birth = "19700101";
//		if(userBirth!=null){
//			birth = userBirth;
//		}
//		vo.setUserBirth(null);
		
//변경 부분		
		Date birth = null;
		if(userBirth!=null){
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
			try {
				birth = transFormat.parse(userBirth);
			} catch (ParseException e) {
				map.put(e.getLocalizedMessage(), "error");
				return map;
			}
		}
		vo.setUserBirth(birth); //Date형태로 변경
		
		String msg = "";
		String key = "";
		try{
			service.saveOrUpdateUser(vo);
			msg = "성공적으로 등록되었습니다.";
			key = "success";
		}catch(Exception e){
			msg = e.getLocalizedMessage();
			key = "error";
		}
		
		map.put(key, msg);
		
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="/user_delete_kys", method=RequestMethod.POST)
	public Map deleteUserKYS(@RequestParam(value="userId")String userId) {
		Map<String,String> map = new HashMap<String,String>();
		AnbUser vo = new AnbUser();
		vo.setUserId(userId);
		String msg = "";
		String key = "";
		try{
			service.removeUser(vo);
			msg = "성공적으로 삭제되었습니다.";
			key = "success";
		}catch(Exception e){
			msg = e.getLocalizedMessage();
			key = "error";
		}
		
		map.put(key, msg);
		
		return map;
	}
}
