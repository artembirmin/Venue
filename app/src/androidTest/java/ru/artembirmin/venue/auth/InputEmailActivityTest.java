package ru.artembirmin.venue.auth;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import ru.artembirmin.venue.presentation.userstories.auth.inputemail.view.InputEmailActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

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
    public void test0() {
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
    public void test1() {
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
     * 6. Осуществлен переход на экран верификации кода
     * <p>
     * Ключ: 8tzlmm892fawdmbi6
     */
    @Test
    public void test2() {
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
     * Ввод некорректного email адреса
     * <p>
     * Действия:
     * 1. Запускаем приложение на экране авторизации
     * 2. Вводим в поле для ввода некорректный email
     * 3. Нажимаем кнопку "Continue"
     * <p>
     * Проверка:
     * 1. Нет надписи "Ожидание подключения"
     * 2. Есть картинка с лого
     * 3. Есть надпись под картинкой
     * 4. Есть поле с ошибкой
     * 5. Есть кнопка продолжения
     * <p>
     * Ключ:
     */
    @Test
    public void test3() {
        inputEmailPage.setTextInputEmail("venue@")
                .closeKeyboard()
                .isConnectingStatusNotDisplayed()
                .isIconDisplayed()
                .isWelcomeTextViewDisplayed()
                .isInputEmailDisplayed()
                .isContinueBtnDisplayed()
                .clickContinueBtn()
                .isInputErroDisplayed();
    }

    /**
     * Ввод некорректного email адреса
     * <p>
     * Действия:
     * 1. Запускаем приложение на экране авторизации
     * 2. Вводим в поле для ввода некорректный email
     * 3. Нажимаем кнопку "Continue"
     * <p>
     * Проверка:
     * 1. Нет надписи "Ожидание подключения"
     * 2. Есть картинка с лого
     * 3. Есть надпись под картинкой
     * 4. Есть поле с ошибкой
     * 5. Есть кнопка продолжения
     * <p>
     * Ключ:
     */
    @Test
    public void test4() {
        inputEmailPage.setTextInputEmail("venue@gmail")
                .closeKeyboard()
                .isConnectingStatusNotDisplayed()
                .isIconDisplayed()
                .isWelcomeTextViewDisplayed()
                .isInputEmailDisplayed()
                .isContinueBtnDisplayed()
                .clickContinueBtn()
                .isInputErroDisplayed();
    }

    /**
     * Ввод некорректного email адреса
     * <p>
     * Действия:
     * 1. Запускаем приложение на экране авторизации
     * 2. Вводим в поле для ввода некорректный email
     * 3. Нажимаем кнопку "Continue"
     * <p>
     * Проверка:
     * 1. Нет надписи "Ожидание подключения"
     * 2. Есть картинка с лого
     * 3. Есть надпись под картинкой
     * 4. Есть поле с ошибкой
     * 5. Есть кнопка продолжения
     * <p>
     * Ключ:
     */
    @Test
    public void test5() {
        inputEmailPage.setTextInputEmail("venue@gmail.")
                .closeKeyboard()
                .isConnectingStatusNotDisplayed()
                .isIconDisplayed()
                .isWelcomeTextViewDisplayed()
                .isInputEmailDisplayed()
                .isContinueBtnDisplayed()
                .clickContinueBtn()
                .isInputErroDisplayed();
    }

    /**
     * Ввод некорректного email адреса
     * <p>
     * Действия:
     * 1. Запускаем приложение на экране авторизации
     * 2. Вводим в поле для ввода некорректный email
     * 3. Нажимаем кнопку "Continue"
     * <p>
     * Проверка:
     * 1. Нет надписи "Ожидание подключения"
     * 2. Есть картинка с лого
     * 3. Есть надпись под картинкой
     * 4. Есть поле с ошибкой
     * 5. Есть кнопка продолжения
     * <p>
     * Ключ:
     */
    @Test
    public void test6() {
        inputEmailPage.setTextInputEmail("venue@gmail.c")
                .closeKeyboard()
                .isConnectingStatusNotDisplayed()
                .isIconDisplayed()
                .isWelcomeTextViewDisplayed()
                .isInputEmailDisplayed()
                .isContinueBtnDisplayed()
                .clickContinueBtn()
                .isInputErroDisplayed();
    }

    @Test
    public void Test7() {

    }
}