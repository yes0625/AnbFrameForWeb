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

import com.anbtech.anbframe.anbweb.vo.DeptManageVo;
import com.anbtech.anbframe.user.service.DepartManageService;

@Controller
public class DepartController {

	private static final Logger LOG = LoggerFactory.getLogger(DepartController.class);
	
	@Autowired
	private DepartManageService service;
	
	@ResponseBody
	@RequestMapping(value="/dept_all", method=RequestMethod.POST)
	public List getDeptAll() throws Exception{

		List list = service.findDept(new DeptManageVo());

		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="/dept_insert_khj", method=RequestMethod.POST)
	public Map insertDeptKHJ(@RequestParam(value="deptName") String dept_name,
			@RequestParam(value="deptCode") String dept_code) {
	
		Map<String,String> map = new HashMap<String,String>();
		LOG.info("{}", dept_name +" || "+dept_code);
		DeptManageVo vo = new DeptManageVo();
		vo.setDept_name(dept_name);
		vo.setDept_code(dept_code);
		
		String msg = "";
		String key = "";
		try{
			service.insertDept(vo);
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
	@RequestMapping(value="/dept_delete_khj", method=RequestMethod.POST)
	public Map deleteDeptKHJ(@RequestParam(value="deptCode")String dept_code) {
		Map<String,String> map = new HashMap<String,String>();
		DeptManageVo vo = new DeptManageVo();
		vo.setDept_code(dept_code);
		String msg = "";
		String key = "";
		try{
			service.deleteDept(vo);
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
