package com.anbtech.anbframe.usermng;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.anbtech.anbframe.anbweb.usermng.dao.UserMngDAO;
import com.anbtech.anbframe.anbweb.usermng.vo.UserMngVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath*:/spring/context-*.xml")
public class UserMngTest {

	private static final Logger LOG = LoggerFactory.getLogger(UserMngTest.class);
	
	@Autowired
	private UserMngDAO dao;
	
	@Test
	public void testName() throws Exception {
		UserMngVO param = new UserMngVO();
		List list = dao.getListUser(param);
		LOG.info("[총 직원은] : {} 명입니다.", list.size());		
		assertNotNull(list);
	}
	
}
