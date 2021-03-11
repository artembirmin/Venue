package ru.artembirmin.venue.presentation.userstories.auth.inputemail.interactor;


import ru.artembirmin.venue.business.repositories.auth.AuthorizationRepository;
import ru.artembirmin.venue.models.net.SendCodeRequest;
import ru.artembirmin.venue.models.net.SendCodeResponse;

import io.reactivex.Single;

public class InputEmailInteractorImpl implements InputEmailInteractor {

    private final AuthorizationRepository repository;

    public InputEmailInteractorImpl(AuthorizationRepository repository) {
        this.repository = repository;
    }

    public Single<SendCodeResponse> sendVerificationCode(SendCodeRequest sendCodeRequest) {
        return repository.sendVerificationCode(sendCodeRequest);
    }
}
