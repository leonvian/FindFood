package com.lvc.foodfinder;

import java.util.List;

import com.lvc.foodfinder.model.Food;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import br.com.lvc.utility.screen.BaseCustomAdapter;

public class FoodListAdapter extends BaseCustomAdapter<Food> {

	public FoodListAdapter(Activity a, List<Food> d) {
		super(a, d);
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		Food food = getItem(position);
		
		if(view == null) {
			view = LayoutInflater.from(activity).inflate(R.layout.food_item, null);
		}
	 
		TextView textViewTitle = (TextView)view.findViewById(R.id.text_view_food_title);
		textViewTitle.setText(food.getTitle());
		
		TextView textViewCompany = (TextView)view.findViewById(R.id.text_view_food_company);
		String brand = food.getBrand();
		if(brand == null || brand.equals("")) {
			textViewCompany.setVisibility(View.GONE);
		} else {
			textViewCompany.setVisibility(View.VISIBLE);
			textViewCompany.setText(brand);
		}
		
		
		TextView textViewDescription = (TextView)view.findViewById(R.id.text_view_food_category);
		textViewDescription.setText(food.getCategory());
		  
		return view;
	}

}