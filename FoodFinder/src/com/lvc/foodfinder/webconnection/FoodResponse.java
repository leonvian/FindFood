package com.lvc.foodfinder.webconnection;

import java.util.List;

import com.lvc.foodfinder.model.Food;

public class FoodResponse {

	private List<Food> list;
	
	
	public FoodResponse() {
	}
	
	public List<Food> getList() {
		return list;
	}
	
	public void setList(List<Food> list) {
		this.list = list;
	}
	
}