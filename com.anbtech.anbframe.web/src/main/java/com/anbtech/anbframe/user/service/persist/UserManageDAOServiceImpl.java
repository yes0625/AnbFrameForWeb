package com.anbtech.anbframe.user.service.persist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.anbtech.anbframe.entities.AnbUser;
import com.anbtech.anbframe.user.service.UserManageDAOService;

/**
 * 직원관리 모듈용 퍼시스턴스단 구현체
 * @create : 2014-12-01 / 서정환 차장
 * @modify : 수정자는 이 코멘트에 자신의 이름작성할것 (다수)
 */
@Service
public class UserManageDAOServiceImpl implements UserManageDAOService{

	private static final String cR= "\n";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private HibernateTemplate hiberTemplate;
	
	public <E, T> List<E> findUser(T entity) throws Exception {
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM anb_user "+cR);		

		String sql = sb.toString();
		
		return (List<E>) jdbcTemplate.query(sql, ParameterizedBeanPropertyRowMapper.newInstance(AnbUser.class));
	}

	public <T> int saveUser(T vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public <T> int updateUser(T vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public <T> int deleteUser(T vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
