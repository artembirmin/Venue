package com.example.venue.data.network.connection;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import io.reactivex.subjects.BehaviorSubject;

public class NetworkChangeReceiver extends BroadcastReceiver {

    private static final String TAG = "Reciever";
    private BehaviorSubject<Boolean> behaviorSubject = BehaviorSubject.create();

    public NetworkChangeReceiver(BehaviorSubject<Boolean> behaviorSubject) {
        this.behaviorSubject = behaviorSubject;
    }

    public BehaviorSubject<Boolean> getBehaviorSubject() {
        return behaviorSubject;
    }

    @Override
    public void onReceive(final Context context, final Intent intent) {

        int status = NetworkUtil.getConnectivityStatusString(context);
        Log.d(TAG, "Sulod sa network reciever");
        System.out.println("DDDDDDDDDDD");
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            if (status == NetworkUtil.NETWORK_STATUS_NOT_CONNECTED) {
                Log.d(TAG, "onReceive: false");
                behaviorSubject.onNext(false);
            } else {
                Log.d(TAG, "onReceive: true");
                behaviorSubject.onNext(true);
            }
        }
    }
}