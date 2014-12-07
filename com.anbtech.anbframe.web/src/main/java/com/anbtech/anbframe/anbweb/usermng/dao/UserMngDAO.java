package com.anbtech.anbframe.anbweb.usermng.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.anbtech.anbframe.anbweb.usermng.vo.UserMngVO;

@Repository
public class UserMngDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 직원 조회
	 *  
	 * @return 직원 리스트
	 */
	public ArrayList getListUser(UserMngVO param){
		String sql = "SELECT EMP_ID empId"
						 + ",ANB_USER_USER_ID  anbUserUserId"
					     + ",EMP_NAME  empName"
				         + ", EMP_EMAIL empEmail"
				         + ", EMP_NAME_ENG empNameEng"
				         + ", EMP_PHONE  empPhone"
				         + ", EMP_HANDPHONE empHandphone"
				         + ", EMP_ADDRESS empAddress"
				         + ", IN_DATE inDate"
				         + ", MAR_DATE marDate"
				         + ", POST_CODE postCode"
				         + ", MAR_YN marYn"
				         + ", CAR_YN carYn"
				         + ", EMP_TYPE empType"
				         + " FROM ANB_EMPLOYEE";
		return (ArrayList)jdbcTemplate.query(sql,new BeanPropertyRowMapper(UserMngVO.class));
	}
	
	/**
	 * 직원 수정
	 *  
	 * @return 수정된 row 수
	 */
	synchronized public int updateUser(UserMngVO param){
		int cnt = 0;
		return cnt;
	}
	
	/**
	 * 직원 삭제
	 *  
	 * @return 삭제된 row 수
	 */
	synchronized public void deleteUser(String user_id){
		StringBuffer sb = new StringBuffer();
		
		sb.append(" DELETE FROM ANB_EMPLOYEE where anb_user_user_id = ?");
		Object[] args = {user_id};
		String sql = sb.toString();
		jdbcTemplate.update(sql, args);
	}
	
	/**
	 * 직원 신규 등록
	 *  
	 * @return N/A
	 */
	synchronized public void insertUser(UserMngVO param) throws Exception{
			String sql = "INSERT INTO ANB_EMPLOYEE (EMP_ID, ANB_USER_USER_ID, ANB_RANK_RANK_CODE, ANB_DIV_DIV_CODE, ANB_PRIVILEGE_PRI_CODE, EMP_NAME, EMP_EMAIL, EMP_NAME_ENG, EMP_PHONE, EMP_HANDPHONE, EMP_ADDRESS, IN_DATE, MAR_DATE, POST_CODE, MAR_YN, CAR_YN, EMP_TYPE) "
					+ "VALUES (? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? ,  ? , ? , ? , ? , ?) ";
			jdbcTemplate.update(sql, new Object[] { 
				getEmpId(),
				param.getAnbUserUserId(),
				param.getAnbRankRankCode(),       
				param.getAnbDivDivCode(),         
				param.getAnbPrivilegePriCode(),   
				param.getEmpName(),               
				param.getEmpEmail(),              
				param.getEmpNameEng(),            
				param.getEmpPhone(),              
				param.getEmpHandphone(),          
				param.getEmpAddress(),            
				param.getInDate(),                
				param.getMarDate(),               
				param.getPostCode(),              
				param.getMarYn(),                 
				param.getCarYn(),                 
				param.getEmpType()});               
				
	}
	
	
	/**
	 * 신규 사번 생성
	 * @return
	 */
	public String getEmpId() throws Exception{
		String sql = "select 'A'||LPAD(TO_NUMBER(SUBSTR(max(emp_id),2,5)) + 1,5,'0')"
				+"from ANB_EMPLOYEE";
		String empId = "";
		empId = (String) jdbcTemplate.queryForObject(sql, String.class);
		return empId;
	}
	
	/**
	 * 아이디 중복 체크
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public int checkDuplicationId(UserMngVO param) throws Exception{
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT COUNT(*) ");
		sb.append(" from ANB_EMPLOYEE ");
        sb.append(" where ANB_USER_USER_ID  = ? ");
        return (int) jdbcTemplate.queryForInt(sb.toString(),new Object[] {param.getAnbUserUserId()});
	}
	
}