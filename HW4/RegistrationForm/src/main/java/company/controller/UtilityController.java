package company.controller;

import company.model.Model;
import company.view.View;

import java.util.Scanner;

public class UtilityController {
    private Model model;
    private View view;

    public UtilityController(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public String inputStringValueWithScanner(Scanner scanner, String regex) {
        getInstruction();
        String result;
        while (!(scanner.hasNextLine() &&
                (result = scanner.nextLine()).matches(regex))){
            view.printMessage(view.WRONG_INPUT_STRING_DATA);
            getInstruction();
        }
        return result;
    }

    private void getInstruction() {
        view.printMessage(view.INPUT_STRING_DATA + getNameOfData());
    }

    private String getNameOfData() {
        if (model.getLastName() == null)
            return view.LAST_NAME;
        return view.NICKNAME;
    }
}
