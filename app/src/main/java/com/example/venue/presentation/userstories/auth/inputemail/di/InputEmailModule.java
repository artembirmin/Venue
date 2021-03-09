package com.example.venue.presentation.userstories.auth.inputemail.di;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.venue.application.di.scopes.PerActivity;
import com.example.venue.business.repositories.auth.AuthorizationRepository;
import com.example.venue.business.repositories.auth.AuthorizationRepositoryImpl;
import com.example.venue.data.network.auth.AuthorizationApi;
import com.example.venue.presentation.navigation.AppRouter;
import com.example.venue.presentation.userstories.auth.inputemail.interactor.InputEmailInteractor;
import com.example.venue.presentation.userstories.auth.inputemail.interactor.InputEmailInteractorImpl;
import com.example.venue.presentation.userstories.auth.inputemail.presenter.InputEmailPresenter;
import com.example.venue.presentation.userstories.auth.inputemail.presenter.InputEmailPresenterImpl;
import com.example.venue.presentation.userstories.auth.inputemail.view.InputEmailView;

import dagger.Module;
import dagger.Provides;

@Module
public class InputEmailModule {

    @PerActivity
    @Provides
    InputEmailPresenter provideInputEmailPresenter(InputEmailInteractor interactor, AppRouter router) {
        return new InputEmailPresenterImpl(interactor, router);
    }

    @PerActivity
    @Provides
    LinearLayoutManager provideLinearLayoutManager(Context context) {
        return new LinearLayoutManager(context);
    }

    @PerActivity
    @Provides
    InputEmailInteractor provideInputEmailInteractor(AuthorizationRepository repository) {
        return new InputEmailInteractorImpl(repository);
    }

    @PerActivity
    @Provides
    AuthorizationRepository provideWeatherApiRepository(AuthorizationApi authorizationApi) {
        return new AuthorizationRepositoryImpl(authorizationApi);
    }
}
