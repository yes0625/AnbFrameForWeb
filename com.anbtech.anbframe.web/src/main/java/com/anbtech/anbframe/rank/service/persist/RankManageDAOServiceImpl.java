package com.anbtech.anbframe.rank.service.persist;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.anbtech.anbframe.entities.AnbRank;
import com.anbtech.anbframe.rank.service.RankManageDAOService;

@Service
public class RankManageDAOServiceImpl implements RankManageDAOService{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private HibernateTemplate hiberTemplate;
	
	public <T, E> List<E> getRankInfo(T entity) throws Exception {
		List<AnbRank> list = hiberTemplate.executeFind(new HibernateCallback<List<AnbRank>>() {

			public List<AnbRank> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria crit = session.createCriteria(AnbRank.class);
				return crit.list();
			}
		});
		return (List<E>) list;
	}

	public <T> int saveRank(T entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public <T> int updateRank(T entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public <T> int removeRank(T entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
