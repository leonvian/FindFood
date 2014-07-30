package com.lvc.foodfinder.test;

import java.util.ArrayList;
import java.util.List;

import com.lvc.foodfinder.database.FoodDAO;
import com.lvc.foodfinder.model.Food;

import android.test.AndroidTestCase;

public class FoodDAOTest extends AndroidTestCase {


	
	public void testSaveFood() {
		FoodDAO foodDAO = FoodDAO.getInstance(getContext());
		foodDAO.deleteAll();
		
		
		int countBeforeSave = foodDAO.count();
		assertTrue(countBeforeSave == 0);
		foodDAO.saveOrUpdade(createFood(1, "Food 1"));
		int countAfterSave = foodDAO.count();
		
		assertTrue(countBeforeSave < countAfterSave);
	}
	
    public void testSaveALotOfFood() {
    	FoodDAO foodDAO = FoodDAO.getInstance(getContext());
		foodDAO.deleteAll();
		
		List<Food> foods = new ArrayList<Food>();
		
		foods.add(createFood(1, "Food 1"));
		foods.add(createFood(2, "Food 2"));
		foods.add(createFood(3, "Food 3"));
		foods.add(createFood(4, "Food 4"));
		foods.add(createFood(5, "Food 5"));
		foods.add(createFood(6, "Food 6"));
		foods.add(createFood(7, "Food 7"));
		foods.add(createFood(8, "Food 8"));
		
		foodDAO.saveOrUpdadeAll(foods);
		
		assertTrue( foods.size() == foodDAO.count()); 
		
	}
    
    
    private Food createFood(int id,String title) {
    	Food food = new Food(id, 12.00, "Brand", 230, 23.0, 12.4, 1, 23.0, "Category", true, title, "pcstext", 12.3, 25.4, 1, 78, 2, 12.0, 23.0, 12.0);
    	return food;
    }
	
}
