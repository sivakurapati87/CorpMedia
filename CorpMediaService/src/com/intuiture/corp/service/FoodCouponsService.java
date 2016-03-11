package com.intuiture.corp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.entity.FoodCoupons;
import com.intuiture.corp.json.FoodCouponsJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class FoodCouponsService {

	@Autowired
	private CommonRepository commonRepository;

	public Boolean saveFoodCoupons(FoodCouponsJson foodCouponsJson) {
		FoodCoupons foodCoupons = null;

		try {
			if (foodCouponsJson.getFoodCouponsId() != null) {
				foodCoupons = (FoodCoupons) commonRepository.findById(foodCouponsJson.getFoodCouponsId(), FoodCoupons.class);
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

	public FoodCouponsJson getFoodCouponsJson(Integer companyId) {
		FoodCouponsJson foodCouponsJson = null;
		try {
			FoodCoupons foodCoupons = (FoodCoupons) commonRepository.getRecordByCompanyId(companyId, FoodCoupons.class);
			if (foodCoupons != null) {
				foodCouponsJson = TransformDomainToJson.getFoodCouponsJson(foodCoupons);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return foodCouponsJson;
	}

}
