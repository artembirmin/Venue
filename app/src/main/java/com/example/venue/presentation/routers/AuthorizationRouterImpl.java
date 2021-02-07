package com.example.venue.presentation.routers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.venue.presentation.inputemail.InputEmailActivity;

public class AuthorizationRouterImpl implements AuthorizationRouter {

    @Override
    public void goToCodeVerification(Activity activity) {
        Intent intent = new Intent((Context) activity, InputEmailActivity.class);
        activity.startActivity(intent);
    }

}
