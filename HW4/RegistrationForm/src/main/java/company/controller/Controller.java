package company.controller;

import company.model.Model;
import company.view.View;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;
    private UtilityController utilityController;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.utilityController = new UtilityController(this.model, this.view);
    }

    public void processUser() {
        Scanner scanner = new Scanner(System.in);
        model.setLastName(utilityController.inputStringValueWithScanner(scanner, Regex.LAST_NAME));
        model.setNickName(utilityController.inputStringValueWithScanner(scanner, Regex.NICKNAME));
    }
}
