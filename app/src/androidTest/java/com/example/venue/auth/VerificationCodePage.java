package com.example.venue.auth;

import com.example.venue.R;
import com.example.venue.base.BasePage;
import com.github.gongw.VerifyCodeView;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class VerificationCodePage extends BasePage {

    private int verificationCodeEditText = R.id.verificationCodeEditText;
    private int root = R.id.verificationCodeRoot;

    public VerificationCodePage isPageDisplayed(){
        checkViewDisplayed(verificationCodeEditText);
        return this;
    }
}
