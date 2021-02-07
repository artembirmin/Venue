package com.example.venue.di.activity.inputemail;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.venue.data.repositories.VerificationCodeRepository;
import com.example.venue.di.activity.PerActivity;
import com.example.venue.domain.calculatorslist.InputEmailInteractor;
import com.example.venue.domain.calculatorslist.InputEmailInteractorImpl;
import com.example.venue.presentation.inputemail.InputEmailPresenter;
import com.example.venue.presentation.inputemail.InputEmailPresenterImpl;
import com.example.venue.presentation.inputemail.InputEmailView;
import com.example.venue.presentation.routers.AuthorizationRouter;

import dagger.Module;
import dagger.Provides;

@Module
public class InputEmailModule {

    InputEmailView view;

    public InputEmailModule(InputEmailView view) {
        this.view = view;
    }

    @PerActivity
    @Provides
    InputEmailPresenter provideInputEmailPresenter(InputEmailInteractor interactor,
                                                   AuthorizationRouter router) {
        return new InputEmailPresenterImpl(interactor, router);
    }

    @PerActivity
    @Provides
    LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager((Context) view);
    }

    @PerActivity
    @Provides
    InputEmailInteractor provideCalculatorsListInteractor(VerificationCodeRepository repository) {
        return new InputEmailInteractorImpl(repository);
    }
}
