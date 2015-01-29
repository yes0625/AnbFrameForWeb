package com.anbtech.anbframe.coupon.service.persist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FoodCouponDAO {
	
	private static final Logger LOG = LoggerFactory.getLogger(FoodCouponDAO.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

}
