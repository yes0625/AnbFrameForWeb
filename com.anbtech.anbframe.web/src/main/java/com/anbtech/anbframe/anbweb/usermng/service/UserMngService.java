package com.anbtech.anbframe.anbweb.usermng.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anbtech.anbframe.anbweb.usermng.vo.UserMngVO;

public interface UserMngService {
	
	public List getListUser(UserMngVO param) throws Exception;
	
	public int updateUser(UserMngVO param) throws Exception;
	
	public int deleteUser(UserMngVO param) throws Exception;
	
	public void inserUser(UserMngVO param) throws Exception;

	public int checkDuplicationId(UserMngVO param) throws Exception;

}
