package com.anbtech.anbframe.anbweb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SampleDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 접속확인용 시간확인 메서드
	 * [수정] 
	 * @return the db time now
	 */
	public String getDbTimeNow(){
		String sql = "SELECT sysdate FROM DUAL";
		return jdbcTemplate.queryForObject(sql,String.class);
	}
	
}
