package com.genm;

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telecom.Connection;
import android.telecom.ConnectionRequest;
import android.telecom.ConnectionService;
import android.telecom.PhoneAccount;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.widget.Toast;


public class PeerJSConnection extends ConnectionService {

    public PeerJSConnection(){
        super();
    }
    public PeerJSConnection(Context c){
        super();

//        ComponentName cn = new ComponentName(c.getPackageName(), PeerJSConnection.class.getName());
//
//        PhoneAccountHandle pah = new PhoneAccountHandle(cn, "example");
//
//        PhoneAccount pa = new PhoneAccount.Builder(pah,"example")
//                .setCapabilities(PhoneAccount.CAPABILITY_SUPPORTS_VIDEO_CALLING)
//                .setCapabilities(PhoneAccount.CAPABILITY_VIDEO_CALLING)
//                .setCapabilities(PhoneAccount.CAPABILITY_CALL_PROVIDER)
//                .build();
//
//        String name = pah.getComponentName().toString();
//        TelecomManager tm = (TelecomManager)c.getSystemService(Context.TELECOM_SERVICE);
//        tm.registerPhoneAccount(pa);
//
//
//        Account[] a = AccountManager.get(c).getAccounts();
//        System.out.println("ACCOUNTS");
//
//        for (Account account : a) {
//            System.out.println(account.name+" "+account.type);
//        }
//
//        Bundle extras = new Bundle();
//        extras.putBoolean(TelecomManager.EXTRA_START_CALL_WITH_SPEAKERPHONE, true);
//
//        tm.addNewIncomingCall(pah, extras);


    }

    @Override
    public Connection onCreateOutgoingConnection(PhoneAccountHandle pa, ConnectionRequest cr){


        return null;
    }
    @Override
    public Connection onCreateIncomingConnection(PhoneAccountHandle pah, ConnectionRequest cr){
        CallConnection callConnection = new CallConnection();
        callConnection.setInitializing();
        return callConnection;
    }

    @Override
    public void onCreateOutgoingConnectionFailed(PhoneAccountHandle pah, ConnectionRequest cr){
        CallConnection callConnection = new CallConnection();
        callConnection.setInitializing();
    }

    @Override
    public void onCreateIncomingConnectionFailed(PhoneAccountHandle pah, ConnectionRequest cr){
        CallConnection callConnection = new CallConnection();
        callConnection.setInitializing();
    }



}
