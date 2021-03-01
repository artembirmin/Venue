package com.example.venue.models.net;

public class SendCodeRequest {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SendCodeRequest(String email) {
        this.email = email;
    }
}
