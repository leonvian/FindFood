package com.lvc.foodfinder.util;

import java.util.HashMap;
import java.util.List;

import com.lvc.foodfinder.model.Food;

public class CacheFood {

	
	private static CacheFood instance;
	
	private HashMap<String, List<Food>> cacheHash = new HashMap<String, List<Food>>();
	
	
	private CacheFood() {
	}
	
	public static CacheFood getInstance() {
		if(instance == null)
			instance = new CacheFood();
		return instance;
	}
	
	public void saveSearchOnCache(String searchTerm, List<Food> result) {
		cacheHash.put(searchTerm, result);
	}
	
	public boolean existSearchOnCache(String searchTerm) {
		return cacheHash.containsKey(searchTerm);
	}
	
	public List<Food> getListFoodOnCache(String searchTerm) {
		List<Food> foodOnCache = cacheHash.get(searchTerm);
		return foodOnCache;
	}

}
