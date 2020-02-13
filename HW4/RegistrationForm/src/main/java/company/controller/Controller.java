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
    private UtilityController utilityController;

    /**
     * Common constructor for creating Controller with model and view
     *
     * @param model - object that we'll be using for connecting with Model entity
     * @param view  - object that we'll be using for connecting with View entity
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.utilityController = new UtilityController(this.model, this.view);
    }

    /**
     * Method which "run" our app
     */

    public void processUser() {
        Scanner scanner = new Scanner(System.in);
        model.setLastName(utilityController.inputStringValueWithScanner(scanner, Regex.LAST_NAME));
        model.setNickName(utilityController.inputStringValueWithScanner(scanner, Regex.NICKNAME));
    }
}
