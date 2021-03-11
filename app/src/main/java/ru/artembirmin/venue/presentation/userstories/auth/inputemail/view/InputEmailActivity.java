package ru.artembirmin.venue.presentation.userstories.auth.inputemail.view;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.venue.R;
import ru.artembirmin.venue.application.App;
import ru.artembirmin.venue.presentation.base.BaseActivity;
import ru.artembirmin.venue.presentation.userstories.auth.inputemail.di.DaggerInputEmailComponent;
import ru.artembirmin.venue.presentation.userstories.auth.inputemail.di.InputEmailModule;
import ru.artembirmin.venue.presentation.userstories.auth.inputemail.presenter.InputEmailPresenter;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;
import java.util.regex.Pattern;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;

public class InputEmailActivity extends BaseActivity
        implements InputEmailView {

    private static final String TAG = InputEmailActivity.class.getSimpleName();
    private final Pattern emailPattern = Pattern.compile("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}");
    private final Navigator navigator = new SupportAppNavigator(this, R.id.container);
    @Inject
    InputEmailPresenter presenter;
    @Inject
    NavigatorHolder navigatorHolder;
    private TextInputLayout textInputLayout;
    private TextInputEditText emailEditText;
    private Button continueButton;
    private TextView connectStatusTextView; //FIXME Имя сделай

    @Override
    protected void onCreate(Bundle savedInstanceState) { //TODO Красоту навести
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_activity_input_email);
        inject();
        findViews();
        continueButton.setOnClickListener(v -> onContinueButton());
        emailEditText.setOnKeyListener(this::onEnterClick);
        presenter.attachView(this);
    }

    public void onContinueButton() {
        String email = Objects.requireNonNull(emailEditText.getText()).toString();
        boolean isSuccessfulResult = emailVerification(email);
        if (isSuccessfulResult) {
            textInputLayout.setErrorEnabled(false);
            presenter.onContinueButtonClick(email);
        } else {
            emailEditText.setError(getResources().getString(R.string.input_error_msg));
            textInputLayout.setErrorEnabled(true);
        }
    }


    private boolean onEnterClick(View v, int keyCode, KeyEvent keyEvent) {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            Log.d(TAG, "onKey: enter");
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
        return true;
    }

    public boolean emailVerification(String email) {
        return emailPattern.matcher(email).matches();
    }

    private void findViews() {
        emailEditText = findViewById(R.id.inputEmailEditText);
        textInputLayout = findViewById(R.id.emailTextInputLayout);
        continueButton = findViewById(R.id.continueButton);
        connectStatusTextView = findViewById(R.id.connectingStatus);
    }

    private void showSnackbar() {
        Snackbar snack = Snackbar.make(findViewById(android.R.id.content), "Text", Snackbar.LENGTH_SHORT);
        View view = snack.getView();
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view.getLayoutParams();
        params.gravity = Gravity.TOP;
        view.setLayoutParams(params);
        snack.show();
    }

    @Override
    protected void inject() {
        DaggerInputEmailComponent.builder()
                .appComponent(App.getInstance().getAppComponent())
                .inputEmailModule(new InputEmailModule())
                .build().inject(this);
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

    @Override
    public void makeToast(int message) {
        Toast.makeText(this, this.getString(message), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onConnectionRestored() {
        connectStatusTextView.setVisibility(TextView.INVISIBLE);
    }

    @Override
    public void onConnectionLost() {
        connectStatusTextView.setVisibility(TextView.VISIBLE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        super.onPause();
        navigatorHolder.removeNavigator();
    }
}