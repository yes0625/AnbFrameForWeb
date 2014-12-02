package com.anbtech.anbframe.user.service;

import java.util.List;
/**
 * 부서관리 모듈용 비즈단 서비스
 * @create : 2014-12-02 / 공혁진 사원
 * @modify : 수정자는 이 코멘트에 자신의 이름작성할것 (다수)
 */
public interface DepartManageService {
	/**
	 * 부서 조회
	 *
	 * @param <E> the element type
	 * @param <T>
	 * @param user_name the user_name
	 * @return the list
	 * @throws Exception the exception
	 */
	public <E, T> List<E> findDept(T entity) throws Exception;
	
	/**
	 * 부서 수정
	 *
	 * @param <E> the element type
	 * @param <T>
	 * @param user_name the user_name
	 * @return the list
	 * @throws Exception the exception
	 */
	public <E, T> int updateDept(T entity) throws Exception;
	
	/**
	 * 부서 추가
	 *
	 * @param <E> the element type
	 * @param <T>
	 * @param user_name the user_name
	 * @return the list
	 * @throws Exception the exception
	 */
	public <E, T> int insertDept(T entity) throws Exception;
	
	/**
	 * 부서 삭제
	 *
	 * @param <E> the element type
	 * @param <T>
	 * @param user_name the user_name
	 * @return the list
	 * @throws Exception the exception
	 */
	public <E, T> int deleteDept(T entity) throws Exception;
}
