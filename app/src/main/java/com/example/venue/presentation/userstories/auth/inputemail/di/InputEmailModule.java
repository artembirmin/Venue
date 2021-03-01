package com.example.venue.presentation.userstories.auth.inputemail.di;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.venue.application.di.scopes.PerActivity;
import com.example.venue.business.repositories.auth.AuthorizationRepository;
import com.example.venue.business.repositories.auth.AuthorizationRepositoryImpl;
import com.example.venue.data.network.auth.AuthorizationApi;
import com.example.venue.presentation.userstories.auth.inputemail.interactor.InputEmailInteractor;
import com.example.venue.presentation.userstories.auth.inputemail.interactor.InputEmailInteractorImpl;
import com.example.venue.presentation.userstories.auth.inputemail.presenter.InputEmailPresenter;
import com.example.venue.presentation.userstories.auth.inputemail.presenter.InputEmailPresenterImpl;
import com.example.venue.presentation.userstories.auth.inputemail.view.InputEmailView;
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
    InputEmailPresenter provideInputEmailPresenter(InputEmailInteractor interactor) {
        return new InputEmailPresenterImpl(interactor);
    }

    @PerActivity
    @Provides
    LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager((Context) view);
    }

    @PerActivity
    @Provides
    InputEmailInteractor provideInputEmailInteractor(AuthorizationRepository repository) {
        return new InputEmailInteractorImpl(repository);
    }

    @PerActivity
    @Provides
    AuthorizationRepository provideWeatherApiRepository(AuthorizationApi weatherApi) {
        return new AuthorizationRepositoryImpl(weatherApi);
    }
}
