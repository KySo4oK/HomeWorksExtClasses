package com.company.controller;

import com.company.model.Model;
import com.company.model.NotUniqueLoginException;
import com.company.view.TextConstant;
import com.company.view.View;

import java.util.Scanner;

import static com.company.view.TextConstant.*;
import static com.company.view.TextConstant.LOGIN_DATA;

/**
 * Created by student on 26.09.2017.
 */
public class InputNoteNoteBook {
    private View view;
    private Scanner sc;

    private String firstName;
    private String login;
    private Model model;
    private UtilityController utilityController;

    InputNoteNoteBook(View view, Model model, Scanner sc) {
        this.view = view;
        this.sc = sc;
        this.model = model;
        this.utilityController = new UtilityController(sc,view);
    }

    void inputNote() {
        inputFirstName();
        inputLogin();
        try {
            model.setNewUser(login,firstName);
        } catch (NotUniqueLoginException e) {
            e.printStackTrace();
            view.printNotUniqueLoginMessage();
            inputLogin();
        }
    }

    private void inputLogin() {
        this.login =
                utilityController.inputStringValueWithScanner
                        (LOGIN_DATA, view.getRegexLogin());
    }

    private void inputFirstName() {
        this.firstName =
                utilityController.inputStringValueWithScanner
                        (FIRST_NAME, view.getRegexName());
    }
}
