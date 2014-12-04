package com.anbtech.anbframe.anbweb;

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

import com.anbtech.anbframe.anbweb.vo.DeptManageVO;
import com.anbtech.anbframe.depart.service.DepartManageService;

/**
 * 직원관리 모듈용 컨트롤러
 * @create : 2014-12-02 / 공혁진 사원
 * @modify : 수정자는 이 코멘트에 자신의 이름작성할것 (다수)
 */
@Controller
public class DepartManageController {

	private static final Logger LOG = LoggerFactory.getLogger(DepartManageController.class);
	
	@Autowired
	private DepartManageService service;
	
	
	@RequestMapping(value = "/department/departList", method = RequestMethod.GET)
	public String userMng(Locale locale, Model model) {
		
		DeptManageVO param = new DeptManageVO();
		//model.addAttribute("list", userMngService.getListUser(param).size());
		
		return "/department/departList";
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
	
	/*@ResponseBody
	@RequestMapping(value="/dept_insert_khj", method=RequestMethod.POST)
	public Map insertDeptKHJ(@RequestParam(value="deptName") String dept_name,
			@RequestParam(value="deptCode") String dept_code) {
	
		Map<String,String> map = new HashMap<String,String>();
		LOG.info("{}", dept_name +" || "+dept_code);
		DeptManageVO vo = new DeptManageVO();
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
		DeptManageVO vo = new DeptManageVO();
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
	}*/
}
