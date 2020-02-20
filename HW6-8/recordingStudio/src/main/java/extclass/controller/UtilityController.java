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
            int scanValue = scanner.nextInt();
            switch (scanValue) {
                default:
                    return result; // record collection or just exit
                case 2:
                    model.sortByGenre();
                case 3:
                    findByLengthRange();
                case 4:
                    addNewSoundToCollection();
            }
        }
    }

    private void addNewSoundToCollection() {
        while (true) {
            view.printAddSongMenu();
            int scanValue = scanner.nextInt();
            switch (scanValue) {
                default:
                    model.addSongByID(scanValue - 1);
                case 1:
                    return;
            }
        }
    }

    private void findByLengthRange() {

    }
}
