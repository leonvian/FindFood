package com.lvc.foodfinder.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.media.MediaRecorder;
import android.speech.RecognizerIntent;

public class MediaUtil {
	//returns whether a microphone exists
    public boolean isMicrophoneExists(Context context) {        
            PackageManager packageManager = context.getPackageManager();
    return packageManager.hasSystemFeature(PackageManager.FEATURE_MICROPHONE);
    }

    //returns whether the microphone is available
    public static boolean isMicrophoneAvailable(Context context) {
        MediaRecorder recorder = new MediaRecorder();
            recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
        recorder.setOutputFile(new File(context.getCacheDir(), "MediaUtil#micAvailTestFile").getAbsolutePath());
        boolean available = true;
        try { 
            recorder.prepare();
        }
        catch (IOException exception) {
            available = false;
        }
        recorder.release();
        return available;
    }

    //returns whether text to speech is available
    public static boolean isTTSAvailable(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent speechIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        List<ResolveInfo> speechActivities = packageManager.queryIntentActivities(speechIntent, 0);
        if (speechActivities.size() != 0) return true;
        return false;
    }

}
