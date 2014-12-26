package com.anbtech.anbframe.common.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anbtech.anbframe.anbweb.vo.CodeMngVO;
import com.anbtech.anbframe.common.service.CodeMngDAOService;
import com.anbtech.anbframe.common.service.CodeMngService;

@Service
public class CodeMngServiceImpl implements CodeMngService{

private static final Logger LOG = LoggerFactory.getLogger(CodeMngServiceImpl.class);
	
	@Autowired
	private CodeMngDAOService codeMngDAOService;
	
	public List getListCode(CodeMngVO param) throws Exception{
		return codeMngDAOService.getListCode(param);
	}

}
