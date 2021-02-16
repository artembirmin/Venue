package com.example.venue.base;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;

public class BasePage {

    protected void clickView(int id) {
        onView(withId(id)).perform(click());
    }

    protected void checkViewDisplayed(int id) {
        onView(withId(id)).check(matches(isDisplayed()));
    }

    protected void checkViewNotDisplayed(int id) {
        onView(withId(id)).check(matches(not(isDisplayed())));
    }
}
