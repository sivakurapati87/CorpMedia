package com.intuiture.corp.dao;

import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.FoodCoupons;
@Repository
public class FoodCouponsRepository extends BaseRepository {
	
	public FoodCoupons findbyId(Integer id) {
		return (FoodCoupons) getSession().get(FoodCoupons.class, id);
	}


}
