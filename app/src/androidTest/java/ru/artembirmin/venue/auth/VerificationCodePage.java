package ru.artembirmin.venue.auth;

import com.example.venue.R;
import ru.artembirmin.venue.base.BasePage;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
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
