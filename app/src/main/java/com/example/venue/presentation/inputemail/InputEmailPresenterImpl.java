package com.example.venue.presentation.inputemail;

import com.example.venue.domain.calculatorslist.InputEmailInteractor;
import com.example.venue.presentation.routers.AuthorizationRouter;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class InputEmailPresenterImpl implements InputEmailPresenter {

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

    final protected void addDisposable(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }
}
