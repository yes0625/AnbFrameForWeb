package com.anbtech.anbframe.usermng.service;

import java.util.List;

import com.anbtech.anbframe.anbweb.vo.UserMngVO;

public interface UserMngService {
	
	public List getListUser(UserMngVO param) throws Exception;
	
	public int updateUser(UserMngVO param) throws Exception;
	
	public void deleteUser(String user_id) throws Exception;
	
	public void inserUser(UserMngVO param) throws Exception;

	public int checkDuplicationId(UserMngVO param) throws Exception;

}
