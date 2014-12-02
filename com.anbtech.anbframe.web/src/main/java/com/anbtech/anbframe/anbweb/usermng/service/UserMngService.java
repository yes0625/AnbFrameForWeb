package com.anbtech.anbframe.anbweb.usermng.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anbtech.anbframe.anbweb.usermng.vo.UserMngVO;

public interface UserMngService {
	
	public List getListUser(UserMngVO param);
	
	public int updateUser(UserMngVO param);
	
	public int deleteUser(UserMngVO param);
	
	public void inserUser(UserMngVO param);

}
