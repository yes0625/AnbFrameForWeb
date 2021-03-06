package com.anbtech.anbframe.coupon.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.anbtech.anbframe.coupon.service.FoodCouponService;
import com.anbtech.anbframe.entities.AnbDiv;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath*:/spring/context-*.xml")
@TransactionConfiguration(defaultRollback=true)
@Transactional
public class FoodCouponServiceTest {

	private static final Logger LOG = LoggerFactory.getLogger(FoodCouponServiceTest.class);
	
	@Autowired
	private FoodCouponService service;

	
	

}
