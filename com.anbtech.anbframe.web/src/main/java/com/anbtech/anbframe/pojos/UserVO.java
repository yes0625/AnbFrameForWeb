package com.anbtech.anbframe.pojos;

/**
 * 사용자 관리에 관한 Value Object
 *
 */
public class UserVO {

	private String user_gender;
	private int gender_count;
	
	public String getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}
	public int getGender_count() {
		return gender_count;
	}
	public void setGender_count(int gender_count) {
		this.gender_count = gender_count;
	}
	
}
