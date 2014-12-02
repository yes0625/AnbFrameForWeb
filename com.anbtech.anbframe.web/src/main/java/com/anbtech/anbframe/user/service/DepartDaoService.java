package com.anbtech.anbframe.user.service;

import java.util.List;

import com.anbtch.anbframe.enums.DepartCondiType;
import com.anbtch.anbframe.enums.UserCondiType;

/**
 * 부서관리 모듈용 퍼시스턴스단 서비스
 * @create : 2014-12-02 / 공혁진 사원
 * @modify : 수정자는 이 코멘트에 자신의 이름작성할것 (다수)
 */
public interface DepartDaoService {
	/**
	 * 부서를 조회한다.
	 *
	 * @param <T> the generic type
	 * @param entity the entity
	 * @return the user info
	 * @throws Exception the exception
	 */
	public <T> List<T> getDeptInfo(T entity) throws Exception;
	
	/**
	 * 조건별 카운트 정보
	 *
	 * @param gender the gender
	 * @return the list
	 * @throws Exception the exception
	 */
	public <T> List<T> countByCondition(DepartCondiType gender) throws Exception;
	
}
