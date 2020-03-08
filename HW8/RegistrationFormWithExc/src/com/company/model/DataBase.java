package com.company.model;

import java.util.ArrayList;

public class DataBase {
    private ArrayList<RegisteredUser> registeredUsers;

    public DataBase() {
        this.registeredUsers = new ArrayList<>();
        registeredUsers.add(new RegisteredUser("login12345", "nameName"));
    }

    void writeNewUser(String login, String firstName) throws NotUniqueLoginException {
        for (RegisteredUser registeredUser : registeredUsers) {
            if (registeredUser.getLogin().equals(login)) throw new NotUniqueLoginException();
        }
        registeredUsers.add(new RegisteredUser(login, firstName));
    }
}
