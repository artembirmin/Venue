package com.example.venue.auth;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.venue.R;
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

    InputEmailPage inputEmailPage = new InputEmailPage();
    VerificationCodePage verificationCodePage = new VerificationCodePage();

    private void checkPermanentViews() {
        onView(ViewMatchers.withId(R.id.coffeeIc)).check(matches(isDisplayed()));
        onView(withId(R.id.welcomeTextView)).check(matches(isDisplayed()));
    }

    /**
     * Начальное открытие экрана авторизации (ввода email)
     * Действия:
     * 1. Запускаем приложение на экране авторизации
     * <p>
     * Проверка:
     * 1. Нет надписи "Ожидание подключения"
     * 2. Есть картинка с лого
     * 3. Есть надпись под картинкой
     * 4. Есть поле для ввода с плейсхолдером
     * 5. Нет сообщения об ошибке
     * 6. Есть кнопка продолжения
     * <p>
     * Ключ: nyh5km4fu9p1w0nkm
     */
    @Test
    public void Test0() {
        inputEmailPage.isConnectingStatusNotDisplayed()
                .isIconDisplayed()
                .isWelcomeTextViewDisplayed()
                .isInputEmailDisplayed()
                .isInputNotErrorDisplayed()
                .isContinueBtnDisplayed();
    }

    /**
     * Ввод рандомных букв и цифр в поле для ввода email
     * <p>
     * Действия:
     * 1. Запускаем приложение на экране авторизации
     * 2. Вводим в поле для ввода рандомные буквы и цифры
     * 3. Нажимаем кнопку "Continue"
     * <p>
     * Проверка:
     * 1. Нет надписи "Ожидание подключения"
     * 2. Есть картинка с лого
     * 3. Есть надпись под картинкой
     * 4. Есть поле с ошибкой
     * 5. Есть кнопка продолжения
     * <p>
     * Ключ: 2kgp7eyx15k0tq6nn
     */
    @Test
    public void Test1() {
        inputEmailPage.setTextInputEmail("mfomd7345gh678hgfd876tfg6")
                .isConnectingStatusNotDisplayed()
                .isIconDisplayed()
                .isWelcomeTextViewDisplayed()
                .isInputEmailDisplayed()
                .isContinueBtnDisplayed();
    }

    /**
     * Ввод корректного email
     * <p>
     * Действия:
     * 1. Запускаем приложение на экране авторизации
     * 2. Вводим в поле для ввода корректный email
     * 3. Нажимаем кнопку "Continue"
     * <p>
     * Проверка:
     * 1. Нет надписи "Ожидание подключения"
     * 2. Есть картинка с лого
     * 3. Есть надпись под картинкой
     * 4. Есть поле ввода без ошибки
     * 5. Есть кнопка продолжения
     * <p>
     * Ключ: 8tzlmm892fawdmbi6
     */
    @Test
    public void Test2() {
        inputEmailPage.setTextInputEmail("venue@ya.ru")
                .closeKeyboard()
                .isConnectingStatusNotDisplayed()
                .isIconDisplayed()
                .isWelcomeTextViewDisplayed()
                .isInputEmailDisplayed()
                .isContinueBtnDisplayed()
                .clickContinueBtn();
        verificationCodePage.isPageDisplayed();
    }

    /**
     * Ввод некорректного email (venue@)
     * <p>
     * Действия:
     * <p>
     * Проверка:
     * <p>
     * Ключ:
     */
    @Test
    public void Test3() {
        inputEmailPage.setTextInputEmail("venue@")
                .closeKeyboard()
                .isInputEmailDisplayed()
                .isConnectingStatusNotDisplayed()
                .isIconDisplayed()
                .isWelcomeTextViewDisplayed()
                .isContinueBtnDisplayed()
                .clickContinueBtn()
                .isInputErroDisplayed();

//        onView(withId(R.id.inputEmailEditText))
//                .perform(typeText("venue@"), closeSoftKeyboard())
//                .check(matches(isDisplayed()));
//        onView(withId(R.id.continueButton)).perform(click()).check(matches(isDisplayed()));
//        onView(withId(R.id.connectingStatus)).check(matches(not(isDisplayed())));
//        checkPermanentViews();
//        onView(withId(R.id.inputEmailEditText)).check(matches(not(hasErrorText("Error"))));
    }

    /**
     *
     */
    @Test
    public void Test4() {

    }

    /**
     *
     */
    @Test
    public void Test5() {

    }

    /**
     *
     */
    @Test
    public void Test6() {

    }

}