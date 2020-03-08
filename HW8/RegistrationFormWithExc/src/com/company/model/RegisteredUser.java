package com.company.model;

public class RegisteredUser {
    private String login;
    private String name;

    RegisteredUser(String login, String name) {
        this.login = login;
        this.name = name;
    }

    String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
