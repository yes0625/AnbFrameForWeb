package com.anbtech.anbframe.anbweb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anbtech.anbframe.entities.AnbUser;
import com.anbtech.anbframe.user.service.UserManageService;

/**
 * 직원관리 모듈용 컨트롤러
 * @create : 2014-12-01 / 서정환 차장
 * @modify : 수정자는 이 코멘트에 자신의 이름작성할것 (다수)
 */
@Controller
@RequestMapping(value="/user")
public class UserManageController {

	@Autowired
	private UserManageService service;
	
	@ResponseBody
	@RequestMapping(value="/user_find", method=RequestMethod.GET)
	public List findUser(){
		AnbUser entity = new AnbUser();
		List<AnbUser> list = null;
		try {
			list = service.findUser(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
}
