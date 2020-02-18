package extclass.controller;

import extclass.model.Model;
import extclass.view.View;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner scanner = new Scanner(System.in);
        InputController inputController = new InputController(model, view, scanner);
        inputController.inputNote();
    }
}
