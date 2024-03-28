package com.example.jeejdbcproject.models;

import java.io.Serializable;

public class User  implements Serializable {
    private String name;
    private String lastName;
    private String birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public User() {
    }

    public User(String name, String lastName, String birthday, String login) {
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.login = login;
    }

    private String login;
}
