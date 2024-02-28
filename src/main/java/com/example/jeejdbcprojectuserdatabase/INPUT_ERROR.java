package com.example.jeejdbcprojectuserdatabase;

public enum INPUT_ERROR {
    EMPTY_FIELD("Fill all the forms"),
    USER_DOES_NOT_EXIST("User doesn't exist"),
    LOGIN_ALREADY_EXISTS("This login already exists"),
    WRONG_PASSWORD("Wrong password"),
    PASSWORD_DO_NOT_MATCH("Passwords doesn't match");

    public final String message;

    INPUT_ERROR(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
