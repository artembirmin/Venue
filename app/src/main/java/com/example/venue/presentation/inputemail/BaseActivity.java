package com.example.venue.presentation.inputemail;

import androidx.annotation.CallSuper;
import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseActivity extends AppCompatActivity {

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    final protected void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }


    @CallSuper
    public void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
}
