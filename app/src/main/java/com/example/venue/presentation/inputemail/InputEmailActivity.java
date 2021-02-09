package com.example.venue.presentation.inputemail;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.venue.App;
import com.example.venue.R;
import com.example.venue.di.activity.inputemail.DaggerInputEmailComponent;
import com.example.venue.di.activity.inputemail.InputEmailModule;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import javax.inject.Inject;

public class InputEmailActivity extends BaseActivity
        implements InputEmailView {

    private static final String TAG = InputEmailActivity.class.getSimpleName();
    @Inject
    InputEmailPresenter presenter;

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
            if(Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                textInputLayout.setErrorEnabled(false);
                presenter.onContinueButtonClick(email);




            } else {
                emailEditText.setError("Oshibka");
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