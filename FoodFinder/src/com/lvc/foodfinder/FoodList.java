package com.lvc.foodfinder;

import java.util.List;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import br.com.lvc.utility.exceptions.AndroidAppException;
import br.com.lvc.utility.screen.smartreminder.SmartReminderClickListener;
import br.com.lvc.utility.screen.smartreminder.SmartReminderUtil;
import br.com.lvc.utility.taskcontrol.SimpleTask;
import br.com.lvc.utility.taskcontrol.TaskResult;

import com.lvc.foodfinder.database.FoodDAO;
import com.lvc.foodfinder.model.Food;
import com.nhaarman.listviewanimations.swinginadapters.AnimationAdapter;
import com.nhaarman.listviewanimations.swinginadapters.prepared.SwingLeftInAnimationAdapter;

public class FoodList extends BaseSearchList<Food, FoodListAdapter> {

	private EditText editTextSearch = null;
	private static boolean showTip = true;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		editTextSearch = (EditText) findViewById(R.id.edit_text_search);
		editTextSearch.setHint(R.string.type_here_to_filter);
		editTextSearch.addTextChangedListener(getTextWatcher());
		
		if(showTip) {
			SmartReminderUtil.showSmartReminderSuccessLong(this, R.string.hold_a_item_to_save_it);	
			showTip = false;
		}
		
	}

	public void onClickSpeak(View view) {
		callSpeachToText();
		editTextSearch.setText("");
	}

	@Override
	protected int layoutID() {
		return R.layout.food_list;
	}
	
	@Override
	public void onItemLongClickEvent(final Food selectedObject) {
		SmartReminderUtil.showSmartReminderAlertYesNo(this, R.string.do_you_want_to_save_this_food, new SmartReminderClickListener() {
			
			@Override
			public void onClick() {
				saveOnlyOneFoodProcess(selectedObject);
			}
		});
	}

	@Override
	public void onClick(Food foodClicked) {
		Bundle bundle = new Bundle();
		bundle.putSerializable(Food.FOOD_DETAIL_BUNDLE_NAME, foodClicked);
		goToNextScreen(FoodDetail.class, bundle);
	}

	@Override
	public FoodListAdapter newAdapter(List<Food> elements) { 
		return new FoodListAdapter(this, elements);
	}

	@Override
	public List<Food> getListElements() throws AndroidAppException {
		List<Food> listFood = (List<Food>) getBundleFromApplication().getSerializable(Food.FOOD_LIST_BUNDLE_NAME);
		return listFood;
	}

	protected void setAdapterOnListView() {
		AnimationAdapter animAdapter = new SwingLeftInAnimationAdapter(adapter);
		animAdapter.setAbsListView(getListView());
		listView.setAdapter(animAdapter); 
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
					saveFoodProcess();
				}
			});
			
			
			return true; 
		}
		
		return false;
	}
	
	private void saveFoodProcess() {
		SimpleTask simpleTask = new SimpleTask(){

			@Override
			public TaskResult executeTask() throws AndroidAppException {
				FoodDAO.getInstance(FoodList.this).saveOrUpdadeAll(elements);
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
	
	private void saveOnlyOneFoodProcess(final Food food) {
		SimpleTask simpleTask = new SimpleTask(){

			@Override
			public TaskResult executeTask() throws AndroidAppException {
				FoodDAO.getInstance(FoodList.this).saveOrUpdade(food);
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

	@Override
	public void voiceRecognitionResult(String result) {
		editTextSearch.setText(result);
	}
}