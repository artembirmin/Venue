package com.example.venue.application.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import io.reactivex.subjects.BehaviorSubject;

public class NetworkChangeReceiver extends BroadcastReceiver {

    private static final String TAG = "Receiver";
    private BehaviorSubject<Boolean> behaviorSubject = BehaviorSubject.create();

    public NetworkChangeReceiver(BehaviorSubject<Boolean> behaviorSubject) {
        this.behaviorSubject = behaviorSubject;
    }

    public NetworkChangeReceiver() {
    }

    public BehaviorSubject<Boolean> getBehaviorSubject() {
        return behaviorSubject;
    }

    @Override
    public void onReceive(final Context context, final Intent intent) {
        int status = NetworkUtil.getConnectivityStatusString(context);
        Log.d(TAG, "on network receiver");
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            if (status != NetworkUtil.NETWORK_STATUS_NOT_CONNECTED) {
                Log.d(TAG, "onReceive: true");
                behaviorSubject.onNext(true);
            } else {
                Log.d(TAG, "onReceive: false");
                behaviorSubject.onNext(false);
            }
        }
    }
}