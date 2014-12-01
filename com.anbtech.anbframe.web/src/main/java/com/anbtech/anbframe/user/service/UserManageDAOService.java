package com.anbtech.anbframe.user.service;

import java.util.List;

/**
 * 직원관리 모듈용 퍼시스턴스단 서비스
 * @create : 2014-12-01 / 서정환 차장
 * @modify : 수정자는 이 코멘트에 자신의 이름작성할것 (다수)
 */
public interface UserManageDAOService {
	
	/**
	 * 사용자 조회
	 *
	 * @param <E> the element type
	 * @param <T> the generic type
	 * @param vo the vo
	 * @return the list
	 * @throws Exception the exception
	 */
	public <E, T> List<E> findUser(T vo) throws Exception;
	
	
	/**
	 * 사용자 생성
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public <T> int saveUser(T vo) throws Exception;

	
	/**
	 * 사용자 수정
	 *
	 * @param <T> the generic type
	 * @param vo the vo
	 * @return the int
	 * @throws Exception the exception
	 */
	public <T> int updateUser(T vo) throws Exception;
	
	/**
	 * 사용자 삭제
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public <T> int deleteUser(T vo) throws Exception;
	
}
