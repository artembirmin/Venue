package com.example.venue.presentation.inputemail;

public interface InputEmailPresenter {

    void attachView(InputEmailView calculatorsListActivity);

    void detachView();

    void onContinueButtonClick(String email);


    void onStop();
}
