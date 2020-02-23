package com.company.controller;

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

    InputNoteNoteBook(View view, Scanner sc) {
        this.view = view;
        this.sc = sc;
    }

    void inputNote() {
        UtilityController utilityController =
                new UtilityController(sc, view);

        this.firstName =
                utilityController.inputStringValueWithScanner
                        (FIRST_NAME, view.getRegexName());
        this.login =
                utilityController.inputStringValueWithScanner
                        (LOGIN_DATA, view.getRegexLogin());
    }
}
