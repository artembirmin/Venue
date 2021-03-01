package com.example.venue.presentation.routers;

import android.app.Activity;
import android.content.Intent;

import com.example.venue.presentation.userstories.auth.verificationcode.VerificationCodeActivity;

public class AuthorizationRouterImpl implements AuthorizationRouter {

    @Override
    public void goToCodeVerification(Activity activity) {
        Intent intent = new Intent(activity, VerificationCodeActivity.class);
        activity.startActivity(intent);
    }
}
