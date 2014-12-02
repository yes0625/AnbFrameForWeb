package com.anbtech.anbframe.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anbtech.anbframe.anbweb.vo.DeptManageVo;
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

	public <E, T> List<E> findDept(T entity) throws Exception {
	
		DeptManageVo vo = (DeptManageVo) entity;
		
		List<DeptManageVo> list = new ArrayList<DeptManageVo>();
		
		/*
		 *  아래와 같이 비즈단에서 경우의 수별 해당 쿼리를 DAO_SERVICE에 작성하든지
		 *  DAO_SERVICE에 VO별 쿼리가 자동 생성되게 하든지 방법은 개발자 에 따라 다르게 구현가능하다.
		 *  아래는 예를 위한 작성임. 둘다 똑같음. 해당 담당자는 아래 수정하든 다르게 개발처리할것.
		 */
		
		if(vo.getDept_name() !=null){
			list = dao_service.findDept(vo);
		}else{
			list = dao_service.findDept(vo);
		}
		
		
		return (List<E>) list;
	}
	public <E, T> int insertDept(T entity) throws Exception {
		DeptManageVo vo = (DeptManageVo) entity;
		
		int insert = dao_service.saveDept(vo);
		
		return insert;
	}
	
	public <E, T> int updateDept(T entity) throws Exception {
		
		DeptManageVo vo = (DeptManageVo) entity;
		
		int update = dao_service.updateDept(vo);
		
		return update;
	}
	
	public <E, T> int deleteDept(T entity) throws Exception {
		DeptManageVo vo = (DeptManageVo) entity;
		
		int delete = dao_service.deleteDept(vo);
		
		return delete;	
		
	
	}
}
