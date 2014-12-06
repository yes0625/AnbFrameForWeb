package com.anbtech.anbframe.user.service;

import java.util.List;

/**
 * 직원관리 모듈용 비즈단 서비스
 * @create : 2014-12-01 / 서정환 차장
 * @modify : 수정자는 이 코멘트에 자신의 이름작성할것 (다수)
 */
public interface UserManageService {

	/**
	 * 사용자 조회
	 *
	 * @param <E> the element type
	 * @param <T>
	 * @param user_name the user_name
	 * @return the list
	 * @throws Exception the exception
	 */
	public <E, T> List<E> findUser(T entity) throws Exception;
	
}
