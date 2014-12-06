package com.anbtech.anbframe.depart.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.anbtech.anbframe.anbweb.vo.DeptManageVO;

/**
 * 부서관리 모듈용 퍼시스턴스단 서비스
 * @create : 2014-12-02 / 공혁진 사원
 * @modify : 수정자는 이 코멘트에 자신의 이름작성할것 (다수)
 */
public interface DepartManageDAOService {
	public List getDeptList(DeptManageVO param);
	
	public void dept_insert(String div_name,String div_code,String div_parent);
	public void dept_update(String div_name,String div_code,String div_parent,String old_code);
	public void dept_delete(String div_code);
	
	/**
	 * 부서정보를 업데이트
	 *
	 * @param <T> the generic type
	 * @param entity the entity
	 * @return the int
	 * @throws Exception the exception
	 */
	@Transactional
	public int updateDiv(DeptManageVO param) throws Exception;	
}
