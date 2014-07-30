package com.lvc.foodfinder.database;

import android.content.Context;

import com.lvc.database.DatabaseHelper;
import com.lvc.database.ReflectionException;
import com.lvc.database.TableUtils;
import com.lvc.foodfinder.model.Food;

public class DataBaseOpenHelperFoodFinder extends DatabaseHelper {

	private static final String DATABASE_NAME = "FoodFinder";
	private static final int DATABASE_VERSION = 1;

	public DataBaseOpenHelperFoodFinder(Context context) {
		super(context, DATABASE_NAME, DATABASE_VERSION);
	}
	
	@Override
	public String[] getScriptsCreateDataBase() throws ReflectionException {
		String[] scriptCreateDataBase = {
				TableUtils.createTableScript(Food.class)
		};

		return scriptCreateDataBase;
	}

	@Override
	public String[] getScriptsUpdateDataBase() throws ReflectionException {
		String[] scriptUpdateDataBase = {
				TableUtils.createDropTableScript(Food.class)
		};

		return scriptUpdateDataBase;
	}
}