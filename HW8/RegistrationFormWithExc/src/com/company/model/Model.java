package com.company.model;

/**
 * Created by student on 26.09.2017.
 */
public class Model {
    private DataBase dataBase;
    public Model(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public void setNewUser(String login, String firstName) throws NotUniqueLoginException {
        dataBase.writeNewUser(login,firstName);
    }
}
