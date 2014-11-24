package com.anbtech.anbframe.user.dao;

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

import com.anbtch.anbframe.enums.UserCondiType;
import com.anbtech.anbframe.user.service.UserDaoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath*:/spring/context-*.xml")
@TransactionConfiguration(defaultRollback=true)
@Transactional
public class UserDAOServiceTest {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserDAOServiceTest.class);
	
	@Autowired
	private UserDaoService service;
	
	@Test
	public void testCountByCondition() throws Exception {
		
		List list = service.countByCondition(UserCondiType.Gender);
		assertNotNull(list);
	}

}
