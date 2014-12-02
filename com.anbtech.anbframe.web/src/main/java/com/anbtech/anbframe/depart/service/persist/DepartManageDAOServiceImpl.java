package com.anbtech.anbframe.depart.service.persist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.anbtech.anbframe.anbweb.vo.DeptManageVO;
import com.anbtech.anbframe.depart.service.DepartManageDAOService;

@Service
public class DepartManageDAOServiceImpl implements DepartManageDAOService{

	private static final String cR= "\n";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private HibernateTemplate hiberTemplate;
	
	public <E, T> List<E> findDept(T entity) throws Exception {
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM anb_div "+cR);		

		String sql = sb.toString();
		
		return (List<E>) jdbcTemplate.query(sql, ParameterizedBeanPropertyRowMapper.newInstance(DeptManageVO.class));
	}

	public <T> int saveDept(T vo) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO anb_div ( ) VALUES ( )");
		return 0;
	}

	public <T> int updateDept(T vo) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE anb_div SET ");
		return 0;
	}

	public <T> int deleteDept(T vo) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("DELETE '' FROM anb_div WHERE 1=1 AND DEPT_CODE = '' ");
		return 0;
	}
}
