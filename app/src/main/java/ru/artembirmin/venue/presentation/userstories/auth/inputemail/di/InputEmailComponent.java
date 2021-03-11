package ru.artembirmin.venue.presentation.userstories.auth.inputemail.di;


import ru.artembirmin.venue.application.di.app.AppComponent;
import ru.artembirmin.venue.application.di.scopes.PerActivity;
import ru.artembirmin.venue.presentation.userstories.auth.inputemail.view.InputEmailActivity;

import dagger.Component;

@Component(dependencies = AppComponent.class, modules = {InputEmailModule.class})
@PerActivity
public interface InputEmailComponent {
    void inject(InputEmailActivity inputEmailActivity);
}
