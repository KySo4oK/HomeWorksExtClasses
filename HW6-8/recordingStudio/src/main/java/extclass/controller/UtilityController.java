package extclass.controller;

import extclass.model.Model;
import extclass.model.Sound;
import extclass.view.View;

import java.util.ArrayList;
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

    public ArrayList<Sound> inputSoundValue() {
        view.printMainMenu();
        ArrayList<Sound> result = new ArrayList<>();
        while (!(scanner.hasNextLine() &&
                (scanner.nextInt() != 5))) {
            view.printWrongInputMessage();
        }
        return result;
    }
}
