package com.anbtech.anbframe.rank.service;

import java.util.List;

public interface RankManageService {

	/**
	 * 직급정보를 조회한다.
	 *
	 * @param <T> the generic type
	 * @param <E> the element type
	 * @param entity the entity
	 * @return the list
	 * @throws Exception the exception
	 */
	public <T,E> List<E> selectRankInfo(T entity) throws Exception;
	
}
