package com.anbtech.anbframe.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.anbtch.anbframe.enums.UserCondiType;
import com.anbtech.anbframe.pojos.UserVO;
import com.anbtech.anbframe.user.service.UserDaoService;

@Service
public class UserDaoServiceImpl implements UserDaoService{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String cR = "\n";
	
	public <T> List<T> getUserInfo(T entity) throws Exception {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.anbtech.anbframe.user.service.UserDaoService#countByCondition(com.anbtch.anbframe.enums.UserCondiType)
	 */
	public <T> List<T> countByCondition(UserCondiType type) throws Exception {
		// 현재 테스트 이므로 성별에 대한 쿼리카운트만 작성
		StringBuffer sb = new StringBuffer();
		if(type.toString().equals(UserCondiType.Gender.toString())){
			sb.append("SELECT user_gender, count(*) AS gender_count " +cR);
			sb.append("FROM anb_user " +cR);
			sb.append("GROUP BY  user_gender " +cR);
		}
		
		String sql = sb.toString();
		
		return (List<T>) jdbcTemplate.query(sql, ParameterizedBeanPropertyRowMapper.newInstance(UserVO.class));
	}

}
