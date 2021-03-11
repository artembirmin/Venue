package ru.artembirmin.venue.presentation.userstories.auth.verificationcode;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.venue.R;

public class VerificationCodeActivity extends AppCompatActivity
        implements VerificationCodeView {

    EditText verificationCodeView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_activity_verification_code);
        verificationCodeView = findViewById(R.id.verificationCodeEditText);
        verificationCodeView.setFocusable(true);
        showSoftKeyboard(verificationCodeView);
    }

    public void showSoftKeyboard(View view) {
        if (view.requestFocus()) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        }
    }

}
