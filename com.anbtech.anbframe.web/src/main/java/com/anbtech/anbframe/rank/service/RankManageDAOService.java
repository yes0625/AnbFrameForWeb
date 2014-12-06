package com.anbtech.anbframe.rank.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface RankManageDAOService {

	/**
	 * 직급정보 가져온다.
	 *
	 * @param <T> the generic type
	 * @param <E> the element type
	 * @param entity the entity
	 * @return the rank info
	 * @throws Exception the exception
	 */
	public <T, E> List<E> getRankInfo(T entity) throws Exception;
	
	/**
	 * 직급정보를 저장한다.
	 *
	 * @param <T> the generic type
	 * @param entity the entity
	 * @return the int
	 * @throws Exception the exception
	 */
	@Transactional
	public <T> int saveRank(T entity) throws Exception;
	
	/**
	 * 직급정보를 업데이트
	 *
	 * @param <T> the generic type
	 * @param entity the entity
	 * @return the int
	 * @throws Exception the exception
	 */
	@Transactional
	public <T> int updateRank(T entity) throws Exception;
	
	/**
	 * 직급정보를 삭제
	 *
	 * @param <T> the generic type
	 * @param entity the entity
	 * @return the int
	 * @throws Exception the exception
	 */
	@Transactional
	public <T> int removeRank(T entity) throws Exception;
	
}
