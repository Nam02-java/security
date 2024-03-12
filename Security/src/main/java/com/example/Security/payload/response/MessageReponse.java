package com.example.Security.payload.response;

import java.util.concurrent.RecursiveTask;

public class MessageReponse {
    private String message;

    public MessageReponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
