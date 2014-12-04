
package com.anbtech.anbframe;

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
import com.anbtech.anbframe.persistance.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath*:/spring/context-*.xml")
@TransactionConfiguration(transactionManager="transactionManager-hibernate",defaultRollback=true)
@Transactional
public class UserServiceTest {

	private static final Logger LOG = LoggerFactory.getLogger(UserServiceTest.class);
	
	@Autowired
	private UserService service;
	
	@Test
	public void testDeleteUser() throws Exception {
		
		AnbUser e1 = new AnbUser();
		e1.setUserId("test_1");

		service.removeUser(e1);
		
		List after_list = service.selectUser(e1);
		
		int after_size = after_list.size();
		LOG.info("[삭제후] {}",after_size);
		
		assertEquals(0, after_size);
	}
	
	@Test
	public void saveUser() throws Exception {
		AnbUser eu = new AnbUser();
		eu.setUserId("anb");
		eu.setUserName("에이앤비");
		service.saveOrUpdateUser(eu);
		
		List<AnbUser> list = service.selectUser(eu);
		for(AnbUser vo : list){
			String userId = vo.getUserId();
			if(userId.equals("anb")){
				LOG.info("{}",userId);
				LOG.info("{}",userId);
			}
		}
	}
	
}
