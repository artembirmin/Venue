package com.example.venue.business.repositories.auth;

import com.example.venue.models.net.SendCodeRequest;
import com.example.venue.models.net.SendCodeResponse;

import io.reactivex.Single;

public interface AuthorizationRepository {

    String WEATHER_API_KEY = "52890ff4987cf82ef04c79cccc4bd74c";
    String BASE_URL = "https://api.openweathermap.org/";

    Single<SendCodeResponse> sendVerificationCode(SendCodeRequest sendCodeRequest);
}
