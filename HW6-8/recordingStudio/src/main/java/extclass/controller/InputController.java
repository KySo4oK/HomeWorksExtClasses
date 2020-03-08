package extclass.controller;

import extclass.model.Model;
import extclass.view.View;

import java.util.Scanner;

public class InputController {
    private Model model;
    private UtilityController utilityController;

    public InputController(Model model, View view, Scanner scanner) {
        this.model = model;
        this.utilityController = new UtilityController(this.model, view, scanner);
    }

    public void inputNote() {
        model.setCollection(utilityController.inputSoundValue());
    }
}
