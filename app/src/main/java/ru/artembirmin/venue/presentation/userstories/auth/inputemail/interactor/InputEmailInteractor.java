package ru.artembirmin.venue.presentation.userstories.auth.inputemail.interactor;


import ru.artembirmin.venue.models.net.SendCodeRequest;
import ru.artembirmin.venue.models.net.SendCodeResponse;

import io.reactivex.Single;

public interface InputEmailInteractor {

    Single<SendCodeResponse> sendVerificationCode(SendCodeRequest sendCodeRequest);
}
