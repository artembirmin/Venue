package com.example.venue.presentation.inputemail;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.venue.App;
import com.example.venue.R;
import com.example.venue.di.activity.inputemail.DaggerInputEmailComponent;
import com.example.venue.di.activity.inputemail.InputEmailModule;

import javax.inject.Inject;

public class InputEmailActivity extends AppCompatActivity
        implements InputEmailView {

    @Inject
    InputEmailPresenter presenter;

    ScrollView scrollViewInputEmail;
    EditText emailEditText;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buildActivityComponentAndInject();
        presenter.attachView(this);
        scrollViewInputEmail = findViewById(R.id.scrollViewInputEmail);
        emailEditText = findViewById(R.id.emailEditText);

    }

    private void buildActivityComponentAndInject() {
        DaggerInputEmailComponent.builder()
                .appComponent(App.getInstance().getAppComponent())
                .inputEmailModule(new InputEmailModule(this))
                .build().inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}