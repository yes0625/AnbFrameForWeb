package com.anbtech.anbframe;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.anbtech.anbframe.anbweb.dao.SampleDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath*:/spring/context-*.xml")
public class BasicTest {

	private static final Logger LOG = LoggerFactory.getLogger(BasicTest.class);
	
	@Autowired
	private SampleDAO dao;
	
	@Test
	public void testName() throws Exception {
		String now = dao.getDbTimeNow();
LOG.info("[현재시간은] : {}", now);		
		assertNotNull(now);
	}
	
}
