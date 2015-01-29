package com.anbtech.anbframe.anbweb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.runner.Request;
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

import com.anbtech.anbframe.anbweb.vo.DeptManageVO;
import com.anbtech.anbframe.depart.service.DepartManageService;

/**
 * 직원관리 모듈용 컨트롤러
 * @create : 2014-12-02 / 공혁진 사원
 * @modify : 수정자는 이 코멘트에 자신의 이름작성할것 (다수)
 */
@Controller
public class DepartManageController {

	private static final Logger logger = LoggerFactory.getLogger(DepartManageController.class);
	
	@Autowired
	private DepartManageService service;
	
	
	@RequestMapping(value = "/department/departList", method = RequestMethod.GET)
	public String userMng(Locale locale, Model model) {
		
		//DeptManageVO param = new DeptManageVO();
		//model.addAttribute("list", userMngService.getListUser(param).size());
		
		return "tiles:department/departList";
	}
	
	@ResponseBody
	@RequestMapping(value = "/departList/getDeptList", method = RequestMethod.POST)
	public List getDeptList(@ModelAttribute DeptManageVO param) {
		return service.getDeptList(param);
	}
	
	@ResponseBody
	@RequestMapping(value="/dept_all", method=RequestMethod.POST)
	public List getDeptAll() throws Exception{

		List list = service.getDeptList(new DeptManageVO());

		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="/departList/dept_save", method=RequestMethod.POST)
	public void saveDept(String div_name,String div_code, String div_parent) throws Exception{
		 service.dept_insert(div_name,div_code,div_parent);
	}
	
	@ResponseBody
	@RequestMapping(value="/departList/dept_update", method=RequestMethod.POST)
	public void updateDept(@RequestParam(required=false,value="old_code") String old_code,String div_name,String div_code, String div_parent) throws Exception{
		service.dept_update(div_name,div_code,div_parent,old_code);
	}
	
	@ResponseBody
	@RequestMapping(value="/departList/dept_delete", method=RequestMethod.POST)
	public void deleteDept(@RequestParam(required=false,value="div_code") String div_code)  throws Exception{
		logger.info(">> :"+div_code);
		service.dept_delete(div_code);
	}
	
}
