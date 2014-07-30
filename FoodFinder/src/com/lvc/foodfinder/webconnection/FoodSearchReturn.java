package com.lvc.foodfinder.webconnection;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lvc.foodfinder.model.Food;



public class FoodSearchReturn {
	
	private int CONNECTION_WELL_SUCEED_CODE = 200;


	private ConnectionStatus meta;
	private FoodResponse response;
	
	public FoodSearchReturn() {
	}

	public ConnectionStatus getMeta() {
		return meta;
	}

	public void setMeta(ConnectionStatus meta) {
		this.meta = meta;
	}

	public FoodResponse getResponse() {
		return response;
	}

	public void setResponse(FoodResponse response) {
		this.response = response;
	}
	
	@JsonIgnore
	public boolean isRequestOk() {
		if(meta != null && meta.getCode() == CONNECTION_WELL_SUCEED_CODE)
			return true;
		else
			return false;		
	}
	
	@JsonIgnore
	public List<Food> getFoods() {
		List<Food> foods = response.getList(); 
		return foods;
	}
	
}