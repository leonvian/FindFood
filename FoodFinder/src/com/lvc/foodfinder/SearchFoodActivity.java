package com.lvc.foodfinder;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import br.com.lvc.utility.exceptions.AndroidAppException;
import br.com.lvc.utility.taskcontrol.SimpleTask;
import br.com.lvc.utility.taskcontrol.TaskResult;

import com.lvc.foodfinder.database.FoodDAO;
import com.lvc.foodfinder.model.Food;
import com.lvc.foodfinder.util.CacheFood;
import com.lvc.foodfinder.webconnection.RestWebserviceFacade;

public class SearchFoodActivity extends BaseSearchList<Food, FavoriteFoodAdapter> {

	private static int REQUEST_UPDATE_WHEN_BACK = 10;
	
	private EditText editTextSearch;
	private TextView textViewLocallyFoodStatus;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		editTextSearch = (EditText) findViewById(R.id.edit_text_search);
	//	editTextSearch.setText("Cupcake"); 
		
		EditText editTextFilter = (EditText) findViewById(R.id.edit_text_filter);
		editTextFilter.addTextChangedListener(getTextWatcher());
		
		textViewLocallyFoodStatus = (TextView) findViewById(R.id.text_view_locally_food_status);
	}
	
	@Override
	protected int layoutID() {
		return R.layout.activity_main;
	}

	public void onClickSpeak(View view) {
	   callSpeachToText();
	   editTextSearch.setText("");
	}
	

	public void onClickFind(View view) {
		findFood();
	}
	
	private void findFood() {
		String searchTerm = editTextSearch.getText().toString();
		if(searchTerm.length() > 0) {
			findFoodProcess(searchTerm);
		} else {
			editTextSearch.setError(getString(R.string.obrigatory_field));
		}
		
	}
	
	
	private void findFoodProcess(final String searchTerm) {
		SimpleTask simpleTask = new SimpleTask() {
			
			List<Food> foodList;
			
			@Override
			public TaskResult executeTask() throws AndroidAppException {
				boolean existOnCache = CacheFood.getInstance().existSearchOnCache(searchTerm);
				
				if(existOnCache) {
					foodList = CacheFood.getInstance().getListFoodOnCache(searchTerm);
				} else {
					foodList = RestWebserviceFacade.getInstance().getListFood(searchTerm);	
					CacheFood.getInstance().saveSearchOnCache(searchTerm, foodList);
				}
				
				return new TaskResult();
			}
			
			@Override
			public void processAfterTask(TaskResult taskResult) {
				Bundle bundle = new Bundle();
				bundle.putSerializable(Food.FOOD_LIST_BUNDLE_NAME, new ArrayList<Food>(foodList));
			    goToNextScreen(FoodList.class, bundle,REQUEST_UPDATE_WHEN_BACK);
			    editTextSearch.setText("");
			}
			
			@Override
			public void processAfterFailTask(AndroidAppException e) {
				showMessageToastLong(e.getMessageFromResource());
			}
		};
		
		executeTask(simpleTask);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == REQUEST_UPDATE_WHEN_BACK) {
			buildList();
		}
	}
	
	@Override
	public void voiceRecognitionResult(String result) {
		editTextSearch.setText(result);
		findFood();
	}

	@Override
	public void onClick(Food foodClicked) {
		Bundle bundle = new Bundle();
		bundle.putSerializable(Food.FOOD_DETAIL_BUNDLE_NAME, foodClicked);
		goToNextScreen(FoodDetail.class, bundle);
	}

	@Override
	public FavoriteFoodAdapter newAdapter(List<Food> elements) {
		return new FavoriteFoodAdapter(this, elements);
	}

	@Override
	public List<Food> getListElements() throws AndroidAppException {
		List<Food> foods = FoodDAO.getInstance(this).getAllElements();
		return foods;
	} 
	
	@Override
	public void configureListViewProcessAfterTask() {
		super.configureListViewProcessAfterTask();
		if(elements.isEmpty()) {
			textViewLocallyFoodStatus.setText(R.string.there_is_no_food_save_locally);
			View favoriteFoodViews = findViewById(R.id.layout_favorites_foods);
			favoriteFoodViews.setVisibility(View.INVISIBLE);
		} else {
			textViewLocallyFoodStatus.setText(R.string.favorite_foods);
		}
	}
	 
}
