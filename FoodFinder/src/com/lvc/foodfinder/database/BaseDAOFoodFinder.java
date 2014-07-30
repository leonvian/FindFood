package com.lvc.foodfinder.database;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import com.lvc.database.BaseDAO;
import com.lvc.database.EntitiePersistable;

public abstract class BaseDAOFoodFinder<T extends EntitiePersistable> extends BaseDAO<T> {

	public BaseDAOFoodFinder(Context context) {
		super(context); 
	}

	@Override
	public SQLiteOpenHelper getDataBaseHelper() { 
		return new DataBaseOpenHelperFoodFinder(getContext());
	}



}
