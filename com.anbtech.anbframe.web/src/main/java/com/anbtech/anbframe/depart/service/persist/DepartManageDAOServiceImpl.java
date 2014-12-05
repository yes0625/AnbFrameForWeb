package com.anbtech.anbframe.depart.service.persist;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.anbtech.anbframe.anbweb.DepartManageController;
import com.anbtech.anbframe.anbweb.usermng.vo.UserMngVO;
import com.anbtech.anbframe.anbweb.vo.DeptManageVO;
import com.anbtech.anbframe.depart.service.DepartManageDAOService;

@Service
public class DepartManageDAOServiceImpl implements DepartManageDAOService{

	private static final String cR= "\n";
	private static final Logger LOG = LoggerFactory.getLogger(DepartManageDAOServiceImpl.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private HibernateTemplate hiberTemplate;
	
	public ArrayList getDeptList(DeptManageVO param){
		String sql = "SELECT DIV_NAME "
				         + ", DIV_CODE "
				         + ", DIV_PARENT "
				         + " FROM ANB_DIV";
		return (ArrayList)jdbcTemplate.query(sql,new BeanPropertyRowMapper(DeptManageVO.class));
	}

	public void dept_insert(String div_name,String div_code,String div_parent){
		StringBuffer sb = new StringBuffer();
//		sb.append(" INSERT INTO ANB_DIV(DIV_NAME,DIV_CODE,DIV_PARENT)VALUES("+div_name+","+div_code+","+div_parent+") ");
		sb.append(" INSERT INTO ANB_DIV(DIV_NAME,DIV_CODE,DIV_PARENT)VALUES(?,?,?) ");
		Object[] obj = {div_name,div_code,div_parent};
		String sql = sb.toString();
		jdbcTemplate.update(sql,obj);
	}
	
	public void dept_update(String div_name,String div_code,String div_parent,String old_code){
		StringBuffer sb = new StringBuffer();
		sb.append(" UPDATE ANB_DIV SET DIV_NAME = ? , DIV_CODE = ? , DIV_PARENT = ? WHERE DIV_CODE=? ");
		Object[] obj = {div_name,div_code,div_parent,old_code};
		String sql = sb.toString();
		LOG.info(">> :"+div_name+"||"+div_code+"||"+div_parent+"||"+old_code);
		LOG.info(">> :"+sql);
		jdbcTemplate.update(sql,obj);
	}
	
	public void dept_delete(String div_code){
		StringBuffer sb = new StringBuffer();
		sb.append(" DELETE FROM ANB_DIV WHERE DIV_CODE=? ");
		Object[] obj = {div_code};
		String sql = sb.toString();
		LOG.info("DELETE>> CODE:"+"||"+div_code+"||");
		LOG.info(">> :"+sql);
		jdbcTemplate.update(sql,obj);
	}
}
