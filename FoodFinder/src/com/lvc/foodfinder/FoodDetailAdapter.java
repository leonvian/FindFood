package com.lvc.foodfinder;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import br.com.lvc.utility.screen.BaseCustomAdapter;

public class FoodDetailAdapter extends BaseCustomAdapter<FoodDetailItem> {

	public FoodDetailAdapter(Activity a, List<FoodDetailItem> d) {
		super(a, d);
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		FoodDetailItem item = getItem(position);
		if(view == null) {
			view = LayoutInflater.from(activity).inflate(R.layout.food_detail_item, null);
		}
		
		TextView textViewTitle = (TextView)view.findViewById(R.id.text_view_food_title);
		textViewTitle.setText(item.getLabel());
		
		TextView textViewValue = (TextView)view.findViewById(R.id.text_view_food_value);
		textViewValue.setText(item.getValue());
		
		return view;
	}
}