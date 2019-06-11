
package com.genm;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import android.Manifest;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telecom.Connection;
import android.telecom.ConnectionService;
import android.telecom.PhoneAccount;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.os.Vibrator;


import static android.content.Context.WINDOW_SERVICE;
import static android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;

public class RNConnectionServiceModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  private Ringtone ringtone;
  private Vibrator vibrator;
  private PowerManager.WakeLock wl;

  public RNConnectionServiceModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNConnectionService";
  }

  @ReactMethod
  public static Boolean isConnectionServiceAvailable() {
    // PhoneAccount is available since api level 23
    return Build.VERSION.SDK_INT >= 23;
  }

  @ReactMethod
  public void showCallUI(){
    if (!isConnectionServiceAvailable()) {
      return;
    }

    PowerManager pm = (PowerManager) this.reactContext.getSystemService(Context.POWER_SERVICE);
    this.wl = pm.newWakeLock( PowerManager.FULL_WAKE_LOCK
            |PowerManager.ACQUIRE_CAUSES_WAKEUP
            | PowerManager.ON_AFTER_RELEASE, "INFO");
    wl.acquire();

    KeyguardManager km = (KeyguardManager) this.reactContext.getSystemService(Context.KEYGUARD_SERVICE);
    KeyguardManager.KeyguardLock kl = km.newKeyguardLock("name");
    kl.disableKeyguard();


    Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);

    // I can't see this ever being null (as always have a default notification)
    // but just incase
    if(notification == null) {
      // alert backup is null, using 2nd backup
      notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
    }


    this.ringtone = RingtoneManager.getRingtone(this.reactContext, notification);

    if(!this.ringtone.isPlaying()){
      this.ringtone.play();
    }

    System.out.println("START TONEw");
    // Get instance of Vibrator from current Context
    this.vibrator = (Vibrator) getReactApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
    long[] pattern = {0, 1000, 1000};
    this.vibrator.vibrate(pattern, 0);

  }

  @ReactMethod
  public void stopRingtone(){
    if (!isConnectionServiceAvailable()) {
      return;
    }

    if(this.ringtone != null){
      this.ringtone.stop();
    }

    if(this.vibrator != null) {
      this.vibrator.cancel();
    }
  }
}