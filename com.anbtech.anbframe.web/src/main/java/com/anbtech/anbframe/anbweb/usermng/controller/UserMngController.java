package com.anbtech.anbframe.anbweb.usermng.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anbtech.anbframe.anbweb.usermng.service.UserMngService;
import com.anbtech.anbframe.anbweb.usermng.vo.UserMngVO;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value="/usermng")
public class UserMngController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserMngController.class);
	private static final String[] MODE = {"0","1"}; // 0 : INSERT , 1 : UPDATE
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	UserMngService userMngService;
	
	
	/**
	 * 직원관리 메인
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/userMng", method = RequestMethod.GET)
	public String userMng(Locale locale, Model model) {
		logger.info("/usermng/userMng");
		return "/usermng/userMng";
	}
	
	/**
	 * 직원 조회
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getListUser", method = RequestMethod.POST)
	public List getListUser(@ModelAttribute UserMngVO param) {
		logger.info("/usermng/userMng");
		List list = new ArrayList();
		try {
			list = userMngService.getListUser(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	public void editUser(@ModelAttribute UserMngVO param) {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 직원 추가
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/insertUser", method = RequestMethod.POST)
	public Map insertUser(@ModelAttribute UserMngVO param) {
		logger.info("/usermng/insertUser");
		Map result = new HashMap();
		try {
			// INSERT
			if(MODE[0].equals(param.getMode())){
				int cnt  = userMngService.checkDuplicationId(param);
				if(cnt > 0)
					result.put("duplication", "Y");
				else{
					userMngService.inserUser(param);
					result.put("duplication", "N");
				}
			// UPDATE
			}else if(MODE[1].equals(param.getMode())){
				int updCnt = userMngService.updateUser(param);
			}
			result.put("success", "Y");
		} catch (Exception e) {
			// TODO: handle exception
			result.put("errorMsg", "직원 등록 중 오류 발생..");
			e.printStackTrace();
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public void deleteUser(@RequestParam(required=false,value="user_id") String user_id) throws Exception {
		//try {
			userMngService.deleteUser(user_id);
		//} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
	}
	
}
