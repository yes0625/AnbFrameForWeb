package com.anbtech.anbframe.coupon.service.domain;

import java.util.Date;

import javax.persistence.Entity;

/**
 * The Class FoodCoupon.
 * @author 서정환 차장
 */
@Entity
public class FoodCoupon {

	private static final int COUNT = 1; // 쿠폰수량
	
	private float fcPrice; // 식권가격
	
	private String fcOwerId; // 식권소유자 아이디
	
	private String purchaseDate; // 식권구매일자
	
	private String assignDate; // 식권 개별 분배 일자
	
	private String fcSerialNo; // 식권 시리얼 번호
	
	private boolean isAlive;	// 식권 사용여부

	public float getFcPrice() {
		return fcPrice;
	}

	public void setFcPrice(float fcPrice) {
		this.fcPrice = fcPrice;
	}

	public String getFcOwerId() {
		return fcOwerId;
	}

	public void setFcOwerId(String fcOwerId) {
		this.fcOwerId = fcOwerId;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getAssignDate() {
		return assignDate;
	}

	public void setAssignDate(String assignDate) {
		this.assignDate = assignDate;
	}

	public String getFcSerialNo() {
		return fcSerialNo;
	}

	public void setFcSerialNo(String fcSerialNo) {
		this.fcSerialNo = fcSerialNo;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public static int getCount() {
		return COUNT;
	}
}
