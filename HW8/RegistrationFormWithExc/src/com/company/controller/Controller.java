package com.company.controller;

import com.company.model.Model;
import com.company.view.View;

import java.util.Scanner;

/**
 * Created by student on 26.09.2017.
 */
public class Controller {
    private View view;
    private Model model;

    public Controller(Model model, View view) {
        this.view = view;
        this.model = model;
    }

    public void processUser() {
        Scanner sc = new Scanner(System.in);
        InputNoteNoteBook inputNoteNoteBook =
                new InputNoteNoteBook(view, model, sc);
        inputNoteNoteBook.inputNote();
    }
}
