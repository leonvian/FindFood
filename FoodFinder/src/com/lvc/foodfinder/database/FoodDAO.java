package com.lvc.foodfinder.database;

import android.content.Context;

import com.lvc.foodfinder.model.Food;

public class FoodDAO extends BaseDAOFoodFinder<Food> {
	
	
	private static FoodDAO instance;
	
	
	public static FoodDAO getInstance(Context context) {
		if(instance == null)
			instance = new FoodDAO(context);
		
		return instance;
	}

	public FoodDAO(Context context) {
		super(context);
	}

	@Override
	public Class<Food> getEntitieClass() {
		return Food.class;
	}
	
}