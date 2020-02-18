package extclass.controller;

import extclass.model.Model;
import extclass.view.View;

import java.util.Scanner;

public class InputController {
    private Model model;
    private View view;
    private Scanner scanner;
    private UtilityController utilityController;

    public InputController(Model model, View view, Scanner scanner) {
        this.model = model;
        this.view = view;
        this.scanner = scanner;
        this.utilityController = new UtilityController(this.model, this.view, this.scanner);
    }

    public void inputNote() {

    }
}
