package com.anbtech.anbframe.anbweb.com.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.anbtech.anbframe.anbweb.com.vo.CodeMngVO;

@Repository
public class CodeMngDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 코드 목록 조회
	 *  
	 * @return 코드 목록
	 */
	public ArrayList getListCode(CodeMngVO param) throws Exception{
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT ");
		sb.append(param.getSel1()+" as code, ");
		sb.append(param.getSel2()+" as name  ");
		sb.append(" FROM  "+param.getTable());
		Object[] args = {};
		if(param.getWhCon1() != null){
			sb.append(" WHERE " +param.getWhCon1()+" = ? ");
			args[0] = param.getWhData1();
		}
		return (ArrayList)jdbcTemplate.query(sb.toString(),args,new BeanPropertyRowMapper(CodeMngVO.class));
	}
}
