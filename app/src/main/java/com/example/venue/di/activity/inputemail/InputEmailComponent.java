package com.example.venue.di.activity.inputemail;

import com.example.venue.di.activity.PerActivity;
import com.example.venue.di.activity.RepositoryModule;
import com.example.venue.di.app.AppComponent;
import com.example.venue.presentation.inputemail.InputEmailActivity;

import dagger.Component;

@Component(dependencies = AppComponent.class, modules = {RepositoryModule.class, InputEmailModule.class})
@PerActivity
public interface InputEmailComponent {
    void inject(InputEmailActivity calculatorsListActivity);
}
