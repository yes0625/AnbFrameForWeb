package com.anbtech.anbframe.depart.service;

import java.util.List;

import com.anbtech.anbframe.anbweb.vo.DeptManageVO;

/**
 * 부서관리 모듈용 비즈단 서비스
 * @create : 2014-12-02 / 공혁진 사원
 * @modify : 수정자는 이 코멘트에 자신의 이름작성할것 (다수)
 */
public interface DepartManageService {
	
	public List getDeptList(DeptManageVO param);
}
