package com.anbtech.anbframe.common.service.persist;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.anbtech.anbframe.anbweb.vo.CodeMngVO;
import com.anbtech.anbframe.common.service.CodeMngDAOService;

@Service
public class CodeMngDAOServiceImpl implements CodeMngDAOService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/* (non-Javadoc)
	 * @see com.anbtech.anbframe.common.service.persist.CodeMngDAOService#getListCode(com.anbtech.anbframe.anbweb.com.vo.CodeMngVO)
	 */
	@Override
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
