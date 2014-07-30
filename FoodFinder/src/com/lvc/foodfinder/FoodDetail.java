package com.lvc.foodfinder;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import br.com.lvc.utility.exceptions.AndroidAppException;
import br.com.lvc.utility.screen.BaseCustomizeListView;
import br.com.lvc.utility.screen.smartreminder.SmartReminderClickListener;
import br.com.lvc.utility.screen.smartreminder.SmartReminderUtil;
import br.com.lvc.utility.taskcontrol.SimpleTask;
import br.com.lvc.utility.taskcontrol.TaskResult;

import com.lvc.foodfinder.database.FoodDAO;
import com.lvc.foodfinder.model.Food;

public class FoodDetail extends BaseCustomizeListView<FoodDetailItem, FoodDetailAdapter> {
	
	Food food = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView textViewTitle = (TextView) findViewById(R.id.text_view_title);
	    food = (Food) getBundleFromApplication().getSerializable(Food.FOOD_DETAIL_BUNDLE_NAME);
		textViewTitle.setText(food.getTitle());
	}

	@Override
	public void onClick(FoodDetailItem clickedElement) {
	}
	
	@Override
	protected int layoutID() {
		return R.layout.food_detail;
	}

	@Override
	public FoodDetailAdapter newAdapter(List<FoodDetailItem> elements) {
		return new FoodDetailAdapter(this, elements);
	}

	@Override
	public List<FoodDetailItem> getListElements() throws AndroidAppException {
		List<FoodDetailItem> itens = createFoodDetailItemListByFood();
		return itens;
	}
 
	
	private List<FoodDetailItem> createFoodDetailItemListByFood() {
		Food food = (Food) getBundleFromApplication().getSerializable(Food.FOOD_DETAIL_BUNDLE_NAME);
		List<FoodDetailItem> itens = new ArrayList<FoodDetailItem>();
		
		itens.add( createFoodDetailItem(R.string.protein, food.getProtein()));
		itens.add( createFoodDetailItem(R.string.fiber, food.getFiber()));
		itens.add( createFoodDetailItem(R.string.brand, food.getBrand()));
		itens.add( createFoodDetailItem(R.string.fat, food.getFat()));
		itens.add( createFoodDetailItem(R.string.saturated_fat, food.getSaturatedfat()));
		itens.add( createFoodDetailItem(R.string.sugar, food.getSugar()));
		itens.add( createFoodDetailItem(R.string.cholesterol, food.getCholesterol()));
		itens.add( createFoodDetailItem(R.string.potassium, food.getPotassium()));
		
		return itens;
	}
	
	private FoodDetailItem createFoodDetailItem(int stringRes, Double value) {
		if(value == null) {
			return createFoodDetailItem(stringRes, "-");
		} else {
			return createFoodDetailItem(stringRes, String.valueOf(value));	
		}
			
		
	}
	
	private FoodDetailItem createFoodDetailItem(int stringRes, String value) {
		FoodDetailItem item = new FoodDetailItem();
		item.setLabel(getString(stringRes));
		if(value == null) 
			value = "-";
		item.setValue(value);
		
		return item;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_add: 
			
			SmartReminderUtil.showSmartReminderAlertYesNo(this, R.string.do_you_want_to_save_search_result, new SmartReminderClickListener() {
				
				@Override
				public void onClick() {
					saveOnlyOneFoodProcess(food);
				}
			});
			
			
			return true; 
		}
		
		return false;
	}
	

	private void saveOnlyOneFoodProcess(final Food food) {
		SimpleTask simpleTask = new SimpleTask(){

			@Override
			public TaskResult executeTask() throws AndroidAppException {
				FoodDAO.getInstance(FoodDetail.this).saveOrUpdade(food);
				return new TaskResult();
			}

			@Override
			public void processAfterTask(TaskResult taskResult) { 
				showMessageToastShort(R.string.food_save_success);
			}

			@Override
			public void processAfterFailTask(AndroidAppException e) {
				showMessageToastShort(R.string.food_save_fail);
				
			}
		};
		
		executeTask(simpleTask);
	}


}
