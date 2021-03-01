package com.example.venue.presentation.navigation;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.example.venue.presentation.userstories.auth.verificationcode.VerificationCodeActivity;

import ru.terrakok.cicerone.android.support.SupportAppScreen;

public class Screens {

    public static final class VerificationCodeScreen extends SupportAppScreen {

        @Override
        public Intent getActivityIntent(Context context) {
            return new Intent(context, VerificationCodeActivity.class);
        }
    }

    public static final class InputEmailScreen extends SupportAppScreen {
        @Override
        public Intent getActivityIntent(Context context) {
            return new Intent(context, InputEmailScreen.class);
        }
    }
}
