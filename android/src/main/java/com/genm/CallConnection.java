package com.genm;

import android.annotation.TargetApi;
import android.os.Build;
import android.telecom.Connection;
import android.util.Log;

import static android.content.ContentValues.TAG;

@TargetApi(Build.VERSION_CODES.M)
public class CallConnection extends Connection{

    public CallConnection(){
        setConnectionProperties(PROPERTY_SELF_MANAGED);
        setAudioModeIsVoip(true);
    }

    @Override
    public  void onAnswer(){
        Log.d(TAG, "On answer to the call");
    }

}
