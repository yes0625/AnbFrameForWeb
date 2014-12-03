package com.anbtech.anbframe.anbweb.usermng.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anbtech.anbframe.anbweb.usermng.dao.UserMngDAO;
import com.anbtech.anbframe.anbweb.usermng.service.UserMngService;
import com.anbtech.anbframe.anbweb.usermng.vo.UserMngVO;

@Service(value="userMngService")
public class UserMngServiceImpl implements UserMngService{

private static final Logger LOG = LoggerFactory.getLogger(UserMngServiceImpl.class);
	
	@Autowired
	private UserMngDAO userMngDAO;
	
	public List getListUser(UserMngVO param){
		return userMngDAO.getListUser(param);
	}
	
	public int updateUser(UserMngVO param){
		return userMngDAO.updateUser(param);
	}
	
	public int deleteUser(UserMngVO param){
		return userMngDAO.deleteUser(param);
	}
	
	public void inserUser(UserMngVO param){
		userMngDAO.insertUser(param);
	}

}
