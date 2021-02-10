package com.example.venue.presentation.inputemail;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.example.venue.App;
import com.example.venue.R;
import com.example.venue.di.activity.inputemail.DaggerInputEmailComponent;
import com.example.venue.di.activity.inputemail.InputEmailModule;
import com.example.venue.presentation.base.BaseActivity;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;
import java.util.regex.Pattern;

import javax.inject.Inject;

public class InputEmailActivity extends BaseActivity
        implements InputEmailView {

    private static final String TAG = InputEmailActivity.class.getSimpleName();
    @Inject
    InputEmailPresenter presenter;

    Pattern emailPattern = Pattern.compile("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}");
    TextInputLayout textInputLayout;
    TextInputEditText emailEditText;
    Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //TODO Красоту навести
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_email);
        buildActivityComponentAndInject();
        presenter.attachView(this);
        emailEditText = findViewById(R.id.emailTextInputEditText);
        textInputLayout = findViewById(R.id.emailTextInputLayout);
        continueButton = findViewById(R.id.continueButton);
        continueButton.setOnClickListener(v -> {
            String email = Objects.requireNonNull(emailEditText.getText()).toString();
            if(emailPattern.matcher(email).matches()){
                textInputLayout.setErrorEnabled(false);
                presenter.onContinueButtonClick(email);

            } else {
                emailEditText.setError("Oshibka");
                showSnackbar();
                textInputLayout.setErrorEnabled(true);
            }
        });
        emailEditText.setOnKeyListener((v, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                Log.d(TAG, "onKey: enter");
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

            }
            return true;
        });
    }

    private void showSnackbar() {

        Snackbar snack = Snackbar.make(findViewById(android.R.id.content), "Text", Snackbar.LENGTH_LONG);
        View view = snack.getView();
        FrameLayout.LayoutParams params =(FrameLayout.LayoutParams)view.getLayoutParams();
        params.gravity = Gravity.TOP;
        view.setLayoutParams(params);
        snack.show();
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

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        presenter.onStop();
        super.onStop();
    }

    @Override
    public void makeToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}