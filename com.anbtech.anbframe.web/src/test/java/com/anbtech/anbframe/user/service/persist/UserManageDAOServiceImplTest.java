package com.anbtech.anbframe.user.service.persist;

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
import com.anbtech.anbframe.user.service.UserManageDAOService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath*:/spring/context-*.xml")
@TransactionConfiguration(defaultRollback=true)
@Transactional
public class UserManageDAOServiceImplTest {

	private static final Logger LOG = LoggerFactory.getLogger(UserManageDAOServiceImplTest.class);
	
	@Autowired
	private UserManageDAOService service;
	
	
	/**
	 * @create : 2014-12-01 / 서정환 차장 (가이드용 메서드 작성)
	 * @modify : 수정한 사람은 날짜와 이름 작성할것.
	 * 
	 * @throws Exception the exception
	 */
	@Test
	public void testUserManageR() throws Exception {
		List list = service.findUser(new AnbUser());
		assertNotNull(list);
	}
	
	@Test
	public void testUserC() throws Exception {
		
	}
	
	@Test
	public void testUserU() throws Exception {
		
	}
	
	@Test
	public void testUserD() throws Exception {
		
	}
	
	
}
