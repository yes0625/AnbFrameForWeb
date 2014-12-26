package com.anbtech.anbframe.anbweb;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anbtech.anbframe.anbweb.vo.CodeMngVO;
import com.anbtech.anbframe.common.service.CodeMngService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value="/common")
public class CodeMngController {
	
	private static final Logger logger = LoggerFactory.getLogger(CodeMngController.class);

	@Autowired
	CodeMngService codeMngServie; 
	
	/**
	 * 코드 조회
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getListCode")
	public List getListCode(@ModelAttribute CodeMngVO param) {
		logger.info("/com/getListCode");
		List list = new ArrayList();
		try {
			list = codeMngServie.getListCode(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
