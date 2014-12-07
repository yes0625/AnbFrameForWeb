package com.anbtech.anbframe.anbweb.com.sevice.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anbtech.anbframe.anbweb.com.dao.CodeMngDAO;
import com.anbtech.anbframe.anbweb.com.sevice.CodeMngService;
import com.anbtech.anbframe.anbweb.com.vo.CodeMngVO;

@Service(value="codeMngService")
public class CodeMngServiceImpl implements CodeMngService{

private static final Logger LOG = LoggerFactory.getLogger(CodeMngServiceImpl.class);
	
	@Autowired
	private CodeMngDAO codeMngDAO;
	
	public List getListCode(CodeMngVO param) throws Exception{
		return codeMngDAO.getListCode(param);
	}

}
