package com.anbtech.anbframe.depart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anbtech.anbframe.anbweb.vo.DeptManageVO;
import com.anbtech.anbframe.depart.service.DepartManageDAOService;
import com.anbtech.anbframe.depart.service.DepartManageService;

/**
 * 부서 관리 모듈용 비즈단 구현체
 * @create : 2014-12-02 / 공혁진 사원
 * @modify : 수정자는 이 코멘트에 자신의 이름작성할것 (다수)
 */
@Service
public class DepartManageServiceImpl implements DepartManageService{
	@Autowired
	private DepartManageDAOService dao_service;

	public List getDeptList(DeptManageVO param){
		return dao_service.getDeptList(param);
	}
	public void dept_insert(String div_name,String div_code,String div_parent){
		dao_service.dept_insert(div_name,div_code,div_parent);
	}
	public void dept_update(String div_name,String div_code,String div_parent,String old_code){
		dao_service.dept_update(div_name,div_code,div_parent,old_code);
	}
	public void dept_delete(String div_code){
		dao_service.dept_delete(div_code);
	}
}
