package com.anbtech.anbframe.user.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.anbtech.anbframe.entities.AnbUser;
import com.anbtech.anbframe.user.service.UserManageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath*:/spring/context-*.xml")
@TransactionConfiguration(defaultRollback=true)
@Transactional
public class UserManageServiceImplTest {

private static final Logger LOG = LoggerFactory.getLogger(UserManageServiceImplTest.class);
	
	@Autowired
	private UserManageService service;
	
	@Test
	public void testR() throws Exception {
		
		List<AnbUser> list = service.findUser(new AnbUser());
		for(AnbUser vo : list){
			String user_name = vo.getUserName();
			String user_id = vo.getUserId();
			LOG.info("아이디는 : {} 이며, 이름은 : {} 입니다.", user_id, user_name);
		}
		assertNotNull(list);
	}
	
}
