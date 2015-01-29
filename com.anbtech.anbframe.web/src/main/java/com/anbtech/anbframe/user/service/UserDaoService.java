package com.anbtech.anbframe.user.service;

import java.util.List;

import com.anbtech.anbframe.enums.UserCondiType;



public interface UserDaoService {

	/**
	 * 사용자를 조회한다.
	 *
	 * @param <T> the generic type
	 * @param entity the entity
	 * @return the user info
	 * @throws Exception the exception
	 */
	public <T> List<T> getUserInfo(T entity) throws Exception;

	/**
	 * 조건별 카운트 정보
	 *
	 * @param gender the gender
	 * @return the list
	 * @throws Exception the exception
	 */
	public <T> List<T> countByCondition(UserCondiType gender) throws Exception;
	
}
