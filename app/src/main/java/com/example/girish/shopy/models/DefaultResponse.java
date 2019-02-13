package com.example.girish.shopy.models;

import com.google.gson.annotations.SerializedName;

public class DefaultResponse {

    // FOR New ACCOUNT LOGIN ERRORS

    @SerializedName("error")
    private boolean error;

    @SerializedName("message")
    private String message;

    public DefaultResponse(boolean error, String message) {
        this.error = error;
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
