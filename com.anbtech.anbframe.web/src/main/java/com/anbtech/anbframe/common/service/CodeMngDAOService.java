package com.anbtech.anbframe.common.service;

import java.util.ArrayList;

import com.anbtech.anbframe.anbweb.vo.CodeMngVO;

public interface CodeMngDAOService {

	/**
	 * 코드 목록 조회
	 *  
	 * @return 코드 목록
	 */
	public abstract ArrayList getListCode(CodeMngVO param) throws Exception;

}