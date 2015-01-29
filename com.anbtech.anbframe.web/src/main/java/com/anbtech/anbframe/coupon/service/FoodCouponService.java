package com.anbtech.anbframe.coupon.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * 식권관리 서비스
 */
public interface FoodCouponService {



	/**
	 * 식권 구매 수량 / 일자
	 *
	 * @param purchaseDate the purchase date
	 * @param fcCount the fc count
	 * @return the int
	 * @throws Exception the exception
	 */
	@Transactional
	public void saveOrUpdatePurchaseInfo(String purchaseDate, int fcCount) throws Exception;
	

	/**
	 * 식권등록 및 수정
	 *
	 * @param date the date
	 * @param fcCount the fc count
	 * @throws Exception the exception
	 */
	public void saveOrUpdateFoodCoupon(String purchaseDate, int fcCount) throws Exception;
	
	

	
}
