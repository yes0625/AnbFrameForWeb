package com.anbtech.anbframe.anbweb.usermng.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anbtech.anbframe.anbweb.usermng.dao.UserMngDAO;
import com.anbtech.anbframe.anbweb.usermng.service.UserMngService;
import com.anbtech.anbframe.anbweb.usermng.vo.UserMngVO;

@Service(value="userMngService")
public class UserMngServiceImpl implements UserMngService{

private static final Logger LOG = LoggerFactory.getLogger(UserMngServiceImpl.class);
	
	@Autowired
	private UserMngDAO userMngDAO;
	
	public List getListUser(UserMngVO param) throws Exception{
		return userMngDAO.getListUser(param);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	synchronized public int updateUser(UserMngVO param) throws Exception{
		return userMngDAO.updateUser(param);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	synchronized public int deleteUser(UserMngVO param) throws Exception{
		return userMngDAO.deleteUser(param);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	synchronized public void inserUser(UserMngVO param) throws Exception{
		userMngDAO.insertUser(param);
	}
	
	public int checkDuplicationId(UserMngVO param) throws Exception{
		return userMngDAO.checkDuplicationId(param);
	}

}
