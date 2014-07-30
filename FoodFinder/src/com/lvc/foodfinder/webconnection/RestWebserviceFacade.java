package com.lvc.foodfinder.webconnection;

import java.util.List;

import org.apache.http.message.BasicHeader;

import br.com.lvc.utility.connection.WebServiceComun;
import br.com.lvc.utility.exceptions.AndroidAppException;

import com.lvc.foodfinder.R;
import com.lvc.foodfinder.model.Food;

public class RestWebserviceFacade extends WebServiceComun {

	private static final String BASE_URL = "https://api.lifesum.com/v1/search/query?type=food&search=";
	private static final String AUTHORIZATION_CODE_LIFE_SUM = "a794ecd348a3f71894426c65c37fea35da89a295bcbad687ca68a96fbfc7d371";
	
	private static RestWebserviceFacade instance;
	
	public static RestWebserviceFacade getInstance() {
		if(instance == null)
			instance = new RestWebserviceFacade();
		
		return instance;
	}

	public List<Food> getListFood(String foodName) throws AndroidAppException {
		String url = BASE_URL.concat(foodName);
		FoodSearchReturn foodSearchReturn  = sendDataGet(url, FoodSearchReturn.class);
		if(foodSearchReturn.isRequestOk()) {
			List<Food> foods = foodSearchReturn.getFoods();
			return foods;	
		} else {
			throw new AndroidAppException(R.string.connection_fail_message);
		}
	}
	
	
	@Override
	public BasicHeader[] getHeaders() {
		BasicHeader[] headers = {
					new BasicHeader("Authorization", AUTHORIZATION_CODE_LIFE_SUM),
					new BasicHeader("Content-type", "application/x-www-form-urlencoded; charset=UTF-8")
			};
			
			return headers;
	}

}