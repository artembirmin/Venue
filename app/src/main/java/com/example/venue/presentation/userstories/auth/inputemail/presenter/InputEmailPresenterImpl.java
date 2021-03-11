package com.example.venue.presentation.userstories.auth.inputemail.presenter;

import com.example.venue.R;
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
    private final InputEmailInteractor interactor;
    private final AppRouter router;
    private InputEmailView view;

    public InputEmailPresenterImpl(InputEmailInteractor interactor, AppRouter router) {
        this.interactor = interactor;
        this.router = router;
    }

    @Override
    public void attachView(InputEmailView activity) {
        this.view = activity;
        subscribeOnReceivers();
    }

    private void subscribeOnReceivers() {
        addDisposable(App.getInstance().getNetworkChangeReceiver().getBehaviorSubject().subscribe(isConnected -> {
            if (isConnected)
                view.onConnectionRestored();
            else view.onConnectionLost();
        }));
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void onContinueButtonClick(String email) {
        SendCodeRequest sendCodeRequest = new SendCodeRequest(email);
        addDisposable(
                interactor.sendVerificationCode(sendCodeRequest)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(sendCodeResponse -> {
                                    view.makeToast(String.valueOf(sendCodeResponse.getCode()));
                                    router.navigateTo(new Screens.VerificationCodeScreen());
                                },
                                throwable -> {
                                    view.makeToast(R.string.something_went_wrong);
                                })
        );
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
