package extclass.controller;

import extclass.model.Model;
import extclass.view.View;

import java.util.Scanner;

public class UtilityController {
    private Model model;
    private View view;
    private Scanner scanner;

    public UtilityController(Model model, View view, Scanner scanner) {
        this.model = model;
        this.view = view;
        this.scanner = scanner;
    }
}
