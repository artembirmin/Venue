package com.example.venue.presentation.inputemail;

import android.app.Activity;

import com.example.venue.domain.inputemail.InputEmailInteractor;
import com.example.venue.models.SendCodeRequest;
import com.example.venue.presentation.base.BasePresenter;
import com.example.venue.presentation.routers.AuthorizationRouter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class InputEmailPresenterImpl extends BasePresenter implements InputEmailPresenter {

    private static final String TAG = "CalculatorListPresenter";
    InputEmailInteractor interactor;
    InputEmailView activity;
    AuthorizationRouter router;
    CompositeDisposable compositeDisposable;

    public InputEmailPresenterImpl(InputEmailInteractor interactor, AuthorizationRouter router) {
        this.interactor = interactor;
        this.router = router;
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
                        .subscribe((sendCodeResponse) -> {
                            activity.makeToast(String.valueOf(sendCodeResponse.getCode()));
                            router.goToCodeVerification((Activity) activity);
                            },
                                throwable -> {
                                    activity.makeToast(String.valueOf("Что-то пошло не так :("));
                                })
        );
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
