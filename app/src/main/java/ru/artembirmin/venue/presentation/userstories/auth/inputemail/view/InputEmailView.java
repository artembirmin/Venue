package ru.artembirmin.venue.presentation.userstories.auth.inputemail.view;


public interface InputEmailView {

    void makeToast(String message);

    void makeToast(int message);

    void onConnectionRestored();

    void onConnectionLost();
}
