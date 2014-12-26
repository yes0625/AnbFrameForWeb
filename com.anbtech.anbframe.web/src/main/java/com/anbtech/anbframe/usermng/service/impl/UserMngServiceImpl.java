package com.anbtech.anbframe.usermng.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anbtech.anbframe.anbweb.vo.UserMngVO;
import com.anbtech.anbframe.usermng.service.UserMngDAOService;
import com.anbtech.anbframe.usermng.service.UserMngService;

@Service(value="userMngService")
public class UserMngServiceImpl implements UserMngService{

private static final Logger LOG = LoggerFactory.getLogger(UserMngServiceImpl.class);
	
	@Autowired
	private UserMngDAOService userMngDAOService;
	
	public List getListUser(UserMngVO param) throws Exception{
		return userMngDAOService.getListUser(param);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	synchronized public int updateUser(UserMngVO param) throws Exception{
		return userMngDAOService.updateUser(param);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	synchronized public void deleteUser(String user_id) throws Exception{
		userMngDAOService.deleteUser(user_id);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	synchronized public void inserUser(UserMngVO param) throws Exception{
		userMngDAOService.insertUser(param);
	}
	
	public int checkDuplicationId(UserMngVO param) throws Exception{
		return userMngDAOService.checkDuplicationId(param);
	}

}
