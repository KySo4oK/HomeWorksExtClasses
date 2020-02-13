package company.controller;

import company.model.Model;
import company.view.View;

import java.util.Scanner;

/**
 * Entity that represent main Controller in our mvc structure
 */

public class Controller {
    private Model model;
    private View view;

    /**
     * Common constructor for creating Controller with model and view
     *
     * @param model - object that we'll be using for connecting with Model entity
     * @param view  - object that we'll be using for connecting with View entity
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Method which "run" our app
     */

    public void processUser() {
        Scanner scanner = new Scanner(System.in);
        InputController inputController = new InputController(view, scanner, model);
        inputController.inputInstructions();
    }
}
