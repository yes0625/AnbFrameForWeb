package com.anbtech.anbframe.anbweb;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

// TODO: Auto-generated Javadoc
/**
 * 컨트롤러 테스트 작성
 * 주의사항 : WAS 작동한후 테스트한다.
 */
public class UserControllerTest {

	/** The Constant REST_SERVICE_URL. */
	private static final String REST_SERVICE_URL = "http://localhost:8080/anbweb/";
	
	/** The rest template. */
	private RestTemplate restTemplate;
	
	/**
	 * Inits the.
	 */
	@Before
	public void init(){
		restTemplate = new RestTemplate();
	}
	
	/**
	 * Test select.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testSelect() throws Exception {
		List list = restTemplate.postForObject(REST_SERVICE_URL+"user_all.do", null, List.class);
		assertNotNull(list);
	}
	
}
