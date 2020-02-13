package company.controller;

import company.model.Model;
import company.view.View;

import java.util.Scanner;

import static company.controller.Regex.LAST_NAME_EN;
import static company.controller.Regex.NICKNAME;

public class InputController {
    private UtilityController utilityController;
    private View view;
    private Scanner scanner;
    private Model model;

    public InputController(View view, Scanner scanner, Model model) {
        this.view = view;
        this.scanner = scanner;
        this.model = model;
        this.utilityController = new UtilityController(this.model, this.view);
    }

    public void inputInstructions() {
        model.setLastName(utilityController.inputStringValueWithScanner(scanner, LAST_NAME_EN));
        model.setNickName(utilityController.inputStringValueWithScanner(scanner, NICKNAME));
    }
}
