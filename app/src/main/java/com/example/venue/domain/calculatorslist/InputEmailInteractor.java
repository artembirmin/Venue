package com.example.venue.domain.calculatorslist;


import java.util.List;

import io.reactivex.Single;

public interface InputEmailInteractor {

    Single<Boolean> sendConfirmationCode();
}
