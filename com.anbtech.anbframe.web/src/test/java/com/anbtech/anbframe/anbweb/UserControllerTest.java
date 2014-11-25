package com.anbtech.anbframe.anbweb;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class UserControllerTest {

	private static final String REST_SERVICE_URL = "http://localhost:8080/anbweb/";
	
	private RestTemplate restTemplate;
	
	@Before
	public void init(){
		restTemplate = new RestTemplate();
	}
	
	@Test
	public void testSelect() throws Exception {
		List list = restTemplate.postForObject(REST_SERVICE_URL+"user_all.do", null, List.class);
		assertNotNull(list);
	}
	
}
