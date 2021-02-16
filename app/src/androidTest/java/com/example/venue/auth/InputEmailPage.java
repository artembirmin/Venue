package com.example.venue.auth;

import com.example.venue.App;
import com.example.venue.R;
import com.example.venue.base.BasePage;
import com.example.venue.base.Page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;

public class InputEmailPage extends BasePage implements Page {

    private final int icon = R.id.coffeeIc;
    private final int continueBtn = R.id.continueButton;
    private final int inputEmailEditText = R.id.inputEmailEditText;
    private final int welcomeTextView = R.id.welcomeTextView;
    private final int connectingStatus = R.id.connectingStatus;

    /**
     * Icon
     */
    public InputEmailPage checkIcon() {
        checkViewDisplayed(icon);
        return this;
    }

    /**
     * ContinueBtn
     */
    public InputEmailPage checkContinueBtn() {
        checkViewDisplayed(continueBtn);
        return this;
    }

    public InputEmailPage clickContinueBtn() {
        clickView(continueBtn);
        return this;
    }

    /**
     * InputEmail
     */
    public InputEmailPage checkInputEmail() {
        clickView(inputEmailEditText);
        return this;
    }

    public InputEmailPage checkInputError() {
        onView(withId(R.id.inputEmailEditText))
                .check(matches(hasErrorText(
                        App.getInstance()
                                .getResources()
                                .getString(R.string.input_error_msg)))
                );
        return this;
    }

    public InputEmailPage checkInputNotError() {
        onView(withId(R.id.inputEmailEditText))
                .check(matches(not(hasErrorText(
                        App.getInstance()
                                .getResources()
                                .getString(R.string.input_error_msg))))
                );
        return this;
    }

    /**
     * ConnectingStatus
     */
    public InputEmailPage checkConnectingStatus() {
        checkViewDisplayed(connectingStatus);
        return this;
    }

    public InputEmailPage checkConnectingStatusNotDisplayed() {
        checkViewNotDisplayed(connectingStatus);
        return this;
    }

    /**
     * WelcomeTextView
     */
    public InputEmailPage checkWelcomeTextView() {
        checkViewDisplayed(welcomeTextView);
        return this;
    }
}
