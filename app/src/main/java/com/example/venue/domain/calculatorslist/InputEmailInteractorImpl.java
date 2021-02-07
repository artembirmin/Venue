package com.example.venue.domain.calculatorslist;


import com.example.venue.data.repositories.VerificationCodeRepository;

import io.reactivex.Single;

public class InputEmailInteractorImpl implements InputEmailInteractor {

    VerificationCodeRepository repository;

    public InputEmailInteractorImpl(VerificationCodeRepository repository) {
       this.repository = repository;
    }

    public Single<Boolean> sendConfirmationCode(){
        return null; //TODO
    }
}
