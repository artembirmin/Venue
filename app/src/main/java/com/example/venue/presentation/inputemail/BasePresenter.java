package com.example.venue.presentation.inputemail;

import androidx.annotation.CallSuper;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter {
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    protected void addDisposable(Disposable disposable){
        compositeDisposable.add(disposable);
    }

    @CallSuper
    public void onStop() {
        compositeDisposable.clear();
    }
}
