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
    private ArrayList<Sound> result;

    public UtilityController(Model model, View view, Scanner scanner) {
        this.model = model;
        this.view = view;
        this.scanner = scanner;
        this.result = new ArrayList<>();
    }

    public ArrayList<Sound> inputSoundValue() {
        while (true) {
            view.printMainMenu();
            if(scanner.hasNextInt()) {
                int scanValue = scanner.nextInt();
                switch (scanValue) {
                    case 1:
                    case 5:
                        view.printSoundNamesWithIndex(result);
                        view.printExitMessage();
                        return result;
                    case 2:
                        model.sortByGenre();
                    case 3:
                        findByLengthRange();
                    case 4:
                        addNewSoundToCollection();
                    default: {
                        view.printWrongInputMessage();
                        break;
                    }

                }
            } else {
                scanner.nextLine();
                view.printWrongInputMessage();
            }
        }
    }

    private void addNewSoundToCollection() {
        while (true) {
            view.printAddSoundMenu(model.getSounds());
            int scanValue = scanner.nextInt();
            if (scanValue > model.getSounds().size()) {
                view.printWrongInputMessage();
                view.printAddSoundMenu(model.getSounds());
            } else if (scanValue == 0) {
                return;
            } else {
                model.addSongByID(scanValue - 1);
            }
        }
    }

    private void findByLengthRange() {
        inputMinLength();
        inputMaxLength();
    }

    private void inputMaxLength() {
    }

    private void inputMinLength() {
    }
}
