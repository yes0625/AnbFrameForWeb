
package com.anbtech.anbframe;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath*:/spring/context-*.xml")
public class BasicTest {

	private static final Logger LOG = LoggerFactory.getLogger(BasicTest.class);
	
	/*@Autowired
	private SampleDAO dao;
	
	@Test
	public void testName() throws Exception {
		String now = dao.getDbTimeNow();
LOG.info("[현재시간은] : {}", now);
LOG.info("[현재시간은 너무 늦었다!!!] : {}", now);
		assertNotNull(now);
	}*/
	
}
