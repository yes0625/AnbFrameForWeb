package com.anbtech.anbframe.user.service.persist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.anbtech.anbframe.anbweb.vo.DeptManageVo;
import com.anbtech.anbframe.depart.service.DepartManageDAOService;

public class DepartManageDAOServiceImpl implements DepartManageDAOService{
private static final String cR= "\n";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private HibernateTemplate hiberTemplate;
	
	public <E, T> List<E> findDept(T entity) throws Exception {
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM anb_dept "+cR);		

		String sql = sb.toString();
		
		return (List<E>) jdbcTemplate.query(sql, ParameterizedBeanPropertyRowMapper.newInstance(DeptManageVo.class));
	}

	public <T> int saveDept(T vo) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO ANB_DEPT ( ) VALUES ( )");
		return 0;
	}

	public <T> int updateDept(T vo) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE ANB_DEPT SET ");
		return 0;
	}

	public <T> int deleteDept(T vo) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("DELETE '' FROM ANB_DEPT WHERE 1=1 AND DEPT_CODE = '' ");
		return 0;
	}
}
