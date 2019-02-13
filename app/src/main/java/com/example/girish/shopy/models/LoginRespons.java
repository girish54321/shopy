package com.example.girish.shopy.models;

public class LoginRespons {


    //FOR LOGIN RESULT ERROR OE WHAT NOT
    private boolean error;
    private String message;
    private User user;

    public LoginRespons(boolean error, String message, User user) {
        this.error = error;
        this.message = message;
        this.user = user;
    }

    public boolean isError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }
}
