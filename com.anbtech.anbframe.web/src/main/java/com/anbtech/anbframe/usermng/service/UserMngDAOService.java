package com.anbtech.anbframe.usermng.service;

import java.util.ArrayList;

import com.anbtech.anbframe.anbweb.vo.UserMngVO;

public interface UserMngDAOService {

	/**
	 * 직원 조회
	 *  
	 * @return 직원 리스트
	 */
	public abstract ArrayList getListUser(UserMngVO param);

	/**
	 * 직원 수정
	 *  
	 * @return 수정된 row 수
	 */
	public abstract int updateUser(UserMngVO param);

	/**
	 * 직원 삭제
	 *  
	 * @return 삭제된 row 수
	 */
	public abstract void deleteUser(String user_id) throws Exception;

	/**
	 * 직원 신규 등록
	 *  
	 * @return N/A
	 */
	public abstract void insertUser(UserMngVO param) throws Exception;

	/**
	 * 신규 사번 생성
	 * @return
	 */
	public abstract String getEmpId() throws Exception;

	/**
	 * 아이디 중복 체크
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public abstract int checkDuplicationId(UserMngVO param) throws Exception;

}