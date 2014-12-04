package com.anbtech.anbframe.depart.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anbtech.anbframe.anbweb.usermng.dao.UserMngDAO;
import com.anbtech.anbframe.anbweb.usermng.vo.UserMngVO;
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
}
