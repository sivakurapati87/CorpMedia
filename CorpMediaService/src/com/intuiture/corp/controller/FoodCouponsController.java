package com.intuiture.corp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.corp.json.FoodCouponsJson;
import com.intuiture.corp.service.FoodCouponsService;

@Controller
@RequestMapping("/FoodCouponsController")
public class FoodCouponsController {
	
	@Autowired
	private FoodCouponsService foodCouponsService;
	
	@RequestMapping(value = "/saveFoodCoupons", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveFoodCoupons(HttpServletRequest request, HttpServletResponse response, @RequestBody FoodCouponsJson foodCouponsJson) {
		return foodCouponsService.saveFoodCoupons(foodCouponsJson);
	}
	
	@RequestMapping(value = "/getFoodCouponsList/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public FoodCouponsJson getFoodCouponsList(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
		return foodCouponsService.getFoodCouponsList(companyId);
	}

}
