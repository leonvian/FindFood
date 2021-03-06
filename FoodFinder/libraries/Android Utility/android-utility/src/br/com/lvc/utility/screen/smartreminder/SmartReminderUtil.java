package br.com.lvc.utility.screen.smartreminder;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import br.com.lvc.utility.R;

public class SmartReminderUtil {

	public static final int TYPE_SUCESS = 1;
	public static final int TYPE_ALERT = 2;
	public static final int TYPE_SUCESS_YES_NO = 3;

	public static final int TYPE_SUCESS_WITH_CONFIRMATION = 4;
	public static final int TYPE_ALERT_WITH_CONFIRMATION = 5;

	static Handler handler = new Handler();

	private static final int SHORT_PERIOD = 2500;
	private static final int LONG_PERIOD = 3000;

	public static void showSmartReminderConnectionNotFound(Activity activity) {
		showSmartReminder(activity, SHORT_PERIOD, TYPE_SUCESS, R.string.dispositivo_desconectado);
	}

	public static void showSmartReminderSuccessShort(Activity activity,String message) {
		showSmartReminder(activity, SHORT_PERIOD, TYPE_SUCESS, message);
	}

	public static void showSmartReminderSuccessLong(Activity activity,String message) {
		showSmartReminder(activity, LONG_PERIOD,TYPE_SUCESS, message);
	}

	public static void showSmartReminderAlertShort(Activity activity, String message) {
		showSmartReminder(activity, SHORT_PERIOD, TYPE_ALERT, message);
	}

	public static void showSmartReminderAlertLong(Activity activity, String message) {
		showSmartReminder(activity, LONG_PERIOD,TYPE_ALERT, message);
	}

	public static void showSmartReminderAlertYesNo(Activity activity, String message, SmartReminderClickListener yesEvent) {
		showSmartReminder(activity, SHORT_PERIOD, TYPE_SUCESS_YES_NO, message,yesEvent, null,null);
	}


	public static void showSmartReminderSucessWithConfirmation(Activity activity, String message, SmartReminderClickListener confirmationEvent) {
		showSmartReminder(activity, SHORT_PERIOD, TYPE_SUCESS_WITH_CONFIRMATION, message,null, null,confirmationEvent);
	}

	public static void showSmartReminderAlertWithConfirmation(Activity activity, String message, SmartReminderClickListener confirmationEvent) {
		showSmartReminder(activity, SHORT_PERIOD, TYPE_ALERT_WITH_CONFIRMATION, message,null, null, confirmationEvent);
	}

	public static void showSmartReminderSucessWithConfirmation(Activity activity, String message) {
		showSmartReminder(activity, SHORT_PERIOD, TYPE_SUCESS_WITH_CONFIRMATION, message,null, null,null);
	}

	public static void showSmartReminderAlertWithConfirmation(Activity activity, String message) {
		showSmartReminder(activity, SHORT_PERIOD, TYPE_ALERT_WITH_CONFIRMATION, message,null, null, null);
	}

	public static void showSmartReminderSucessWithConfirmation(Activity activity, int message, SmartReminderClickListener confirmationEvent) {
		showSmartReminder(activity, SHORT_PERIOD, TYPE_SUCESS_WITH_CONFIRMATION, message,null, null,confirmationEvent);
	}

	public static void showSmartReminderAlertWithConfirmation(Activity activity, int message, SmartReminderClickListener confirmationEvent) {
		showSmartReminder(activity, SHORT_PERIOD, TYPE_ALERT_WITH_CONFIRMATION, message,null, null, confirmationEvent);
	}

	public static void showSmartReminderSucessWithConfirmation(Activity activity, int message) {
		showSmartReminder(activity, SHORT_PERIOD, TYPE_SUCESS_WITH_CONFIRMATION, message,null, null,null);
	}

	public static void showSmartReminderAlertWithConfirmation(Activity activity, int message) {
		showSmartReminder(activity, SHORT_PERIOD, TYPE_ALERT_WITH_CONFIRMATION, message,null, null, null);
	}

	public static void showSmartReminderAlertYesNo(Activity activity, String message, SmartReminderClickListener yesEvent, SmartReminderClickListener noEvent) {
		showSmartReminder(activity, SHORT_PERIOD, TYPE_SUCESS_YES_NO, message,yesEvent, noEvent,null);
	}

	private static void showSmartReminder(Activity context, int time, int type, String message) {
		showSmartReminder(context,time, type, message, null, null,null);
	}

	private static void showSmartReminder(Activity context, int time, int type, String message, final SmartReminderClickListener yesEvent, final SmartReminderClickListener noEvent, final SmartReminderClickListener dismissEvent) {
		showSmartReminderIfNecessary(context, time, type, message, yesEvent, noEvent,dismissEvent);
	}

	public static void showSmartReminderSuccessShort(Activity activity,int message) {
		showSmartReminder(activity, SHORT_PERIOD, TYPE_SUCESS, message);
	}

	public static void showSmartReminderSuccessLong(Activity activity,int message) {
		showSmartReminder(activity, LONG_PERIOD,TYPE_SUCESS, message);
	}

	public static void showSmartReminderAlertShort(Activity activity, int message) {
		showSmartReminder(activity, SHORT_PERIOD, TYPE_ALERT, message);
	}

	public static void showSmartReminderAlertLong(Activity activity, int message) {
		showSmartReminder(activity, LONG_PERIOD,TYPE_ALERT, message);
	}

	public static void showSmartReminderAlertYesNo(Activity activity, int message, SmartReminderClickListener yesEvent) {
		showSmartReminder(activity, SHORT_PERIOD, TYPE_SUCESS_YES_NO, message,yesEvent, null,null);
	}

	public static void showSmartReminderAlertYesNo(Activity activity, int message, SmartReminderClickListener yesEvent, SmartReminderClickListener noEvent) {
		showSmartReminder(activity, SHORT_PERIOD, TYPE_SUCESS_YES_NO, message,yesEvent, noEvent,null);
	}

	private static void showSmartReminder(Activity context, int time, int type, int message) {
		showSmartReminder(context,time, type, message, null, null,null);
	}

	private static void showSmartReminder(Activity context, int time, int type, int message, final SmartReminderClickListener yesEvent, final SmartReminderClickListener noEvent, final SmartReminderClickListener dismissEvent) {
		showSmartReminderIfNecessary(context, time, type,  context.getString(message), yesEvent, noEvent, dismissEvent);
	}

	private static void showSmartReminderIfNecessary(Activity context, int time, int type, String message, final SmartReminderClickListener yesEvent, final SmartReminderClickListener noEvent, final SmartReminderClickListener dismissEvent) {
		int layout = getLayoutByType(type); 
		final ViewGroup smartReminderView = (ViewGroup) context.findViewById(layout);

		if(smartReminderView == null) 
			Toast.makeText(context, message, Toast.LENGTH_LONG).show();
		else 
			showSmartReminder(context, smartReminderView, time, type, message, yesEvent, noEvent, dismissEvent);

	}

	private static void showSmartReminder(Activity context, final ViewGroup smartReminderView, int time, int type, String message, final SmartReminderClickListener yesEvent, final SmartReminderClickListener noEvent, final SmartReminderClickListener dismissEvent) {
		if(smartReminderView.getVisibility() != View.VISIBLE) {

			TextView textViewSmartReminder = (TextView) smartReminderView.findViewById(R.id.text_view_smart_reminder);
			textViewSmartReminder.setText(message);

			configureButtonActionsSmartReminder(type,smartReminderView, yesEvent, noEvent);
			configureButtonActionSmartReminderConfirmation(type, smartReminderView, dismissEvent);

			smartReminderView.setVisibility(View.VISIBLE);

			if(type == TYPE_SUCESS || type == TYPE_ALERT) {
				handler.postDelayed(new Runnable() {

					@Override
					public void run() {
						smartReminderView.setVisibility(View.GONE);	
					}

				}, time);
			}
		}
	}

	private static void configureButtonActionsSmartReminder(int type, final ViewGroup smartReminderView, final SmartReminderClickListener yesEvent, final SmartReminderClickListener noEvent) {
		if(type == TYPE_SUCESS_YES_NO) {
			View buttonYes = smartReminderView.findViewById(R.id.button_yes);
			buttonYes.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					yesEvent.onClickSmartReminderButton(smartReminderView);
				}
			});


			View buttonNo = smartReminderView.findViewById(R.id.button_no);
			buttonNo.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					if(noEvent == null) 
						smartReminderView.setVisibility(View.GONE);
					else
						noEvent.onClickSmartReminderButton(smartReminderView); 
				}
			});
		} 
	}

	private static void configureButtonActionSmartReminderConfirmation(final int type, final ViewGroup smartReminderView, final SmartReminderClickListener dismissEvent ) {
		if(type == TYPE_ALERT_WITH_CONFIRMATION || type == TYPE_SUCESS_WITH_CONFIRMATION) {
			View buttonDismiss = smartReminderView.findViewById(R.id.button_dismiss);
			buttonDismiss.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					if(dismissEvent == null) 
						smartReminderView.setVisibility(View.GONE);
					else
						dismissEvent.onClickSmartReminderButton(smartReminderView);
				}
			});
		}
	}


	private static int getLayoutByType(int type) {
		switch (type) {
		case TYPE_ALERT:
			return R.id.smart_reminder_alert;

		case TYPE_SUCESS:
			return R.id.smart_reminder_success;

		case TYPE_ALERT_WITH_CONFIRMATION:
			return R.id.smart_reminder_alert_with_confirmation;

		case TYPE_SUCESS_WITH_CONFIRMATION:
			return R.id.smart_reminder_sucess_with_confirmation;

		case TYPE_SUCESS_YES_NO:
			return R.id.smart_reminder_success_question;

		default:
			return 0;
		}
	}
}