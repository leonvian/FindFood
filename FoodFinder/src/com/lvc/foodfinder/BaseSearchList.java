package com.lvc.foodfinder;

import java.util.ArrayList;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import br.com.lvc.utility.screen.BaseCustomizeListView;

public abstract class BaseSearchList<T, Z extends ArrayAdapter<T>>  extends BaseCustomizeListView<T, Z> {
 
	
	public static final int SPEECH_REQUEST_CODE = 1;
	
	protected void callSpeachToText() {
		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");

		try {
			startActivityForResult(intent, SPEECH_REQUEST_CODE);
			
		} catch (ActivityNotFoundException a) {
			Toast.makeText(this,R.string.device_not_support_speech_to_text, Toast.LENGTH_SHORT).show();
		}
	}
	
	public abstract void voiceRecognitionResult(String result);
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if(requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
				ArrayList<String> texts = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
				String bestResult = texts.get(0);
				voiceRecognitionResult(bestResult);
		}
		 
	}

}
