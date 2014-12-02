package com.anbtech.anbframe.user.service;

import java.util.List;
/**
 * 부서관리 모듈용 퍼시스턴스단 서비스
 * @create : 2014-12-02 / 공혁진 사원
 * @modify : 수정자는 이 코멘트에 자신의 이름작성할것 (다수)
 */
public interface DepartManageDAOService {
	/**
	 * 부서 조회
	 *
	 * @param <E> the element type
	 * @param <T> the generic type
	 * @param vo the vo
	 * @return the list
	 * @throws Exception the exception
	 */
	public <E, T> List<E> findDept(T vo) throws Exception;
	
	
	/**
	 * 부서 생성
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public <T> int saveDept(T vo) throws Exception;

	
	/**
	 * 부서 수정
	 *
	 * @param <T> the generic type
	 * @param vo the vo
	 * @return the int
	 * @throws Exception the exception
	 */
	public <T> int updateDept(T vo) throws Exception;
	
	/**
	 * 부서 삭제
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public <T> int deleteDept(T vo) throws Exception;
}
