package ru.artembirmin.venue.presentation.userstories.auth.inputemail.presenter;

import ru.artembirmin.venue.presentation.userstories.auth.inputemail.view.InputEmailView;

public interface InputEmailPresenter {

    void attachView(InputEmailView calculatorsListActivity);

    void detachView();

    void onContinueButtonClick(String email);

    void onStop();
}
