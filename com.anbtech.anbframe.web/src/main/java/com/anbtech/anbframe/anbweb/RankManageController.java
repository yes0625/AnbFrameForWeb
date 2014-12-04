package com.anbtech.anbframe.anbweb;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anbtech.anbframe.entities.AnbEmployee;
import com.anbtech.anbframe.entities.AnbRank;
import com.anbtech.anbframe.rank.service.RankManageService;

@Controller
@RequestMapping(value="/rank")
public class RankManageController {
	
	private static final Logger LOG = LoggerFactory.getLogger(RankManageController.class);

	@Autowired
	private RankManageService service;
	
	@RequestMapping(value="/manage_rank", method=RequestMethod.GET)
	public String manageRankMain(){
		return "admin/manage_rank";
	}
	/*
	
	{
	    "dataSet": {
	      "message": {
	          "result": "OK",
	          "messageId": "M3000000",
	          "messageName": "정상처리입니다."
	        },
	        "recordSets": {
	            "grid_todolist": {
	                "nc_list": [{"number":"1","todo":"Check Email"},
	                {"number":"2","todo":"Dentist's appoinment"},
	                {"number":"3","todo":"Wash car"},
	                {"number":"4","todo":"Pick up kids"},
	                {"number":"5","todo":"pay bills"}]
	            }
	        }
	    }
	}
	*/
	@ResponseBody
	@RequestMapping(value="/rank_list", method=RequestMethod.GET)
	public Map selectRankInfo(@RequestParam(required=false,value="name") String name){
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		Map<String,Object> key_map = new HashMap<String,Object>();
		
		Map<String,Object> grid_map = new HashMap<String,Object>();
		
		List<AnbRank> list = new ArrayList<AnbRank>();
		
		try {
			AnbRank pojo = new AnbRank();
			
			if(name!=null){
				
				String ko_name = new String(name.getBytes("8859_1"), "UTF-8");
				LOG.info("[넘어온 직급명] : {}, 변환된 직급명 : {}", name, ko_name);
				pojo.setRankName(ko_name);
			}
			
			list = service.selectRankInfo(pojo);
			
			for(AnbRank vo : list){
				vo.setAnbEmployees(null);
			}
			
			Map<String,Object> list_map = new HashMap<String,Object>();
			list_map.put("nc_list", list);
			
			grid_map.put("grid_todolist", list_map);
			
			key_map.put("message", "");
			key_map.put("recordSets", grid_map);
			
			map.put("dataSet", key_map);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
}
