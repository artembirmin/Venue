package com.example.venue.presentation.userstories.auth.inputemail.presenter;

import com.example.venue.application.App;
import com.example.venue.models.net.SendCodeRequest;
import com.example.venue.presentation.base.BasePresenter;
import com.example.venue.presentation.navigation.AppRouter;
import com.example.venue.presentation.navigation.Screens;
import com.example.venue.presentation.userstories.auth.inputemail.interactor.InputEmailInteractor;
import com.example.venue.presentation.userstories.auth.inputemail.view.InputEmailView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class InputEmailPresenterImpl extends BasePresenter implements InputEmailPresenter {

    private static final String TAG = "CalculatorListPresenter";
    InputEmailInteractor interactor;
    InputEmailView activity;
    AppRouter router;

    public InputEmailPresenterImpl(InputEmailInteractor interactor) {
        this.interactor = interactor;
        router = App.getInstance().getRouter();
    }

    @Override
    public void attachView(InputEmailView activity) {
        this.activity = activity;
    }

    @Override
    public void detachView() {
        activity = null;
    }

    @Override
    public void onContinueButtonClick(String email) {
        SendCodeRequest sendCodeRequest = new SendCodeRequest(email);
        addDisposable(
                interactor.sendVerificationCode(sendCodeRequest)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(sendCodeResponse -> {
                                    activity.makeToast(String.valueOf(sendCodeResponse.getCode()));
                                    router.navigateTo(new Screens.VerificationCodeScreen());

                                },
                                throwable -> {
                                    activity.makeToast("Что-то пошло не так :(");
                                })
        );
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
