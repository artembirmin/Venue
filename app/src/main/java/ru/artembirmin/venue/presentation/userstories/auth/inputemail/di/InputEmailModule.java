package ru.artembirmin.venue.presentation.userstories.auth.inputemail.di;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;

import ru.artembirmin.venue.application.di.scopes.PerActivity;
import ru.artembirmin.venue.business.repositories.auth.AuthorizationRepository;
import ru.artembirmin.venue.business.repositories.auth.AuthorizationRepositoryImpl;
import ru.artembirmin.venue.data.network.auth.AuthorizationApi;
import ru.artembirmin.venue.presentation.navigation.AppRouter;
import ru.artembirmin.venue.presentation.userstories.auth.inputemail.interactor.InputEmailInteractor;
import ru.artembirmin.venue.presentation.userstories.auth.inputemail.interactor.InputEmailInteractorImpl;
import ru.artembirmin.venue.presentation.userstories.auth.inputemail.presenter.InputEmailPresenter;
import ru.artembirmin.venue.presentation.userstories.auth.inputemail.presenter.InputEmailPresenterImpl;

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
    AuthorizationRepository provideAuthorizationRepository(AuthorizationApi authorizationApi) {
        return new AuthorizationRepositoryImpl(authorizationApi);
    }
}
