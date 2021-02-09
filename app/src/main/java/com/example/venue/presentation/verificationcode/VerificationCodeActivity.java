package com.example.venue.presentation.verificationcode;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.venue.R;

public class VerificationCodeActivity extends AppCompatActivity
        implements VerificationCodeView{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_code);
    }

}
