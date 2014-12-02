package com.anbtech.anbframe.anbweb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anbtech.anbframe.anbweb.vo.DeptManageVo;
import com.anbtech.anbframe.user.service.DepartManageService;

/**
 * 직원관리 모듈용 컨트롤러
 * @create : 2014-12-02 / 공혁진 사원
 * @modify : 수정자는 이 코멘트에 자신의 이름작성할것 (다수)
 */
@Controller
@RequestMapping(value="/dept")
public class DepartManageController {

	@Autowired
	private DepartManageService service;
	
	@ResponseBody
	@RequestMapping(value="/dept_find", method=RequestMethod.GET)
	public List findDept(){
		DeptManageVo entity = new DeptManageVo();
		List<DeptManageVo> list = null;
		try {
			list = service.findDept(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
}
