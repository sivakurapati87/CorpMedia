package com.intuiture.corp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.FoodCouponsRepository;
import com.intuiture.corp.entity.FoodCoupons;
import com.intuiture.corp.json.FoodCouponsJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class FoodCouponsService {
	
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private FoodCouponsRepository foodCouponsRepository;
	
	
	
	public Boolean saveFoodCoupons(FoodCouponsJson foodCouponsJson) {
		FoodCoupons foodCoupons = null;

		
		try {
			if (foodCouponsJson.getFoodCouponsId() != null) {
				foodCoupons = foodCouponsRepository.findbyId(foodCouponsJson.getFoodCouponsId());
			} else {
				foodCoupons = new FoodCoupons();
			}
			TransformJsonToDomain.getFoodCoupons(foodCoupons, foodCouponsJson);
			if (foodCouponsJson.getFoodCouponsId() != null) {
				commonRepository.update(foodCoupons);
			} else {
				commonRepository.persist(foodCoupons);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public FoodCouponsJson getFoodCouponsList(Integer companyId) {
		FoodCouponsJson foodCouponsJson = null;
		try {
			List<FoodCoupons> foodCouponsList = (List<FoodCoupons>) commonRepository.getAllRecordsByCompanyId(companyId, FoodCoupons.class);
			if (foodCouponsList != null && foodCouponsList.size() > 0) {
				for (FoodCoupons foodCoupons : foodCouponsList) {
					foodCouponsJson =TransformDomainToJson.getFoodCouponsJson(foodCoupons);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return foodCouponsJson;
	}
	
	


}
