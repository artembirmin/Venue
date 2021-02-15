package com.example.venue;

import android.content.Context;
import android.content.Intent;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.venue.presentation.inputemail.InputEmailActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class InputEmailActivityTest {

    @Rule
    public ActivityScenarioRule<InputEmailActivity> activityRule =
            new ActivityScenarioRule<InputEmailActivity>(InputEmailActivity.class);

    private void checkPermanentViews() {
        onView(withId(R.id.coffeeIc)).check(matches(isDisplayed()));
        onView(withId(R.id.welcomeTextView)).check(matches(isDisplayed()));
    }

    /** Начальное открытие экрана авторизации (ввода email)
     * Действия:
     * 1. Запускаем приложение на экране авторизации
     *
     * Проверка:
     * 1. Нет надписи "Ожидание подключения"
     * 2. Есть картинка с лого
     * 3. Есть надпись под картинкой
     * 4. Есть поле для ввода с плейсхолдером
     * 5. Нет сообщения об ошибке
     * 6. Есть кнопка продолжения
     *
     * Ключ: nyh5km4fu9p1w0nkm
     */
    @Test
    public void Test0(){
        onView(withId(R.id.connectingStatus)).check(matches(not(isDisplayed())));
        onView(withId(R.id.inputEmailEditText))
                .check(matches(isDisplayed()));
        onView(withId(R.id.continueButton)).check(matches(isDisplayed()));
        checkPermanentViews();
        onView(withId(R.id.inputEmailEditText)).check(matches(hasErrorText("Error")));
    }

    /** Ввод 1-2 букв в поле для ввода email
     *
     * Действия:
     * 1. Запускаем приложение на экране авторизации
     * 2. Вводим в поле для ввода 1-2 буквы
     * 3. Нажимаем кнопку "Continue"
     *
     * Проверка:
     * 1. Нет надписи "Ожидание подключения"
     * 2. Есть картинка с лого
     * 3. Есть надпись под картинкой
     * 4. Есть поле с ошибкой
     * 5. Есть кнопка продолжения
     *
     * Ключ: 2kgp7eyx15k0tq6nn
     */
    @Test
    public void Test1() {
        // Context of the app under test.
        onView(withId(R.id.inputEmailEditText))
                .perform(typeText("ve"), closeSoftKeyboard());
        onView(withId(R.id.continueButton)).perform(click());
        onView(withId(R.id.connectingStatus)).check(matches(not(isDisplayed())));
        checkPermanentViews();
        onView(withId(R.id.inputEmailEditText)).check(matches(hasErrorText("Error")));
    }

    /**
     *
     */
    @Test
    public void Test2(){

    }

    /**
     *
     */
    @Test
    public void Test3(){

    }

    /**
     *
     */
    @Test
    public void Test4(){

    }

    /**
     *
     */
    @Test
    public void Test5(){

    }

    /**
     *
     */
    @Test
    public void Test6(){

    }

}