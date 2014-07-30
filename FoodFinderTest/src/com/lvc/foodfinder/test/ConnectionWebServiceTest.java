package com.lvc.foodfinder.test;

import java.util.List;

import br.com.lvc.utility.exceptions.AndroidAppException;

import com.lvc.foodfinder.model.Food;
import com.lvc.foodfinder.webconnection.RestWebserviceFacade;

import android.test.AndroidTestCase;

public class ConnectionWebServiceTest extends AndroidTestCase {


	public void testFoodSearch() throws AndroidAppException {
		List<Food> foods = RestWebserviceFacade.getInstance().getListFood("cola");
		assertTrue(foods.size() > 0);
		
	}
	
}