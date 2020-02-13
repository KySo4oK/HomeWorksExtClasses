package company.controller;

import company.model.Model;
import company.view.View;

import java.util.Scanner;

import static company.controller.Regex.*;
import static company.view.ConstantContainer.LAST_NAME;
import static company.view.ConstantContainer.NICKNAME;

public class InputController {
    private UtilityController utilityController;
    private View view;
    private Scanner scanner;
    private Model model;

    public InputController(View view, Scanner scanner, Model model) {
        this.view = view;
        this.scanner = scanner;
        this.model = model;
        this.utilityController = new UtilityController(this.model, this.view, this.scanner);
    }

    public void inputInstructions() {
        String regexForLastName = (String.valueOf(View.resourceBundle.getLocale()).equals("ua"))
                ? LAST_NAME_UA_REGEX : LAST_NAME_EN_REGEX;
        model.setLastName(utilityController.inputStringValueWithScanner(LAST_NAME, regexForLastName));
        model.setNickName(utilityController.inputStringValueWithScanner(NICKNAME, NICKNAME_REGEX));
    }
}
