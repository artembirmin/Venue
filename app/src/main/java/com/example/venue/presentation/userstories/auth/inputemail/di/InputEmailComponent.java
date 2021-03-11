package com.example.venue.presentation.userstories.auth.inputemail.di;


import com.example.venue.application.di.app.AppComponent;
import com.example.venue.application.di.scopes.PerActivity;
import com.example.venue.presentation.userstories.auth.inputemail.view.InputEmailActivity;

import dagger.Component;

@Component(dependencies = AppComponent.class, modules = {InputEmailModule.class})
@PerActivity
public interface InputEmailComponent {
    void inject(InputEmailActivity inputEmailActivity);
}
