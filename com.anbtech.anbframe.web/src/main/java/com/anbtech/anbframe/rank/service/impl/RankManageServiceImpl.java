package com.anbtech.anbframe.rank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anbtech.anbframe.rank.service.RankManageDAOService;
import com.anbtech.anbframe.rank.service.RankManageService;

@Service
public class RankManageServiceImpl implements RankManageService{

	@Autowired
	private RankManageDAOService dao_service;
	
	public <T, E> List<E> selectRankInfo(T entity) throws Exception {
		
		return dao_service.getRankInfo(entity);
	}

}
