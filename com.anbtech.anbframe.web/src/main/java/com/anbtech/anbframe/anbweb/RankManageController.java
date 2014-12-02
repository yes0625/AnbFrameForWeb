package com.anbtech.anbframe.anbweb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anbtech.anbframe.entities.AnbEmployee;
import com.anbtech.anbframe.entities.AnbRank;
import com.anbtech.anbframe.rank.service.RankManageService;

@Controller
@RequestMapping(value="/rank")
public class RankManageController {

	@Autowired
	private RankManageService service;
	
	@RequestMapping(value="/manage_rank", method=RequestMethod.GET)
	public String manageRankMain(){
		return "admin/manage_rank";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/rank_list", method=RequestMethod.GET)
	public List selectRankInfo(){
		List<AnbRank> list = new ArrayList<AnbRank>();
		
		AnbRank vo = new AnbRank();
		Set<AnbEmployee> invo = new HashSet<AnbEmployee>();
		vo.setAnbEmployees(invo);
		
		try {
			list = service.selectRankInfo(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}
