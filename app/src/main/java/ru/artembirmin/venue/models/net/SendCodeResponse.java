package ru.artembirmin.venue.models.net;

public class SendCodeResponse {
    private String response;
    private int code;

    public SendCodeResponse(String response, int code) {
        this.response = response;
        this.code = code;
    }

    public SendCodeResponse(String response) {
        this.response = response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
