package company.controller;

import company.model.Model;
import company.view.View;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;


/**
 * Entity for input value from scanner and set them to Model
 */

public class UtilityController {
    private Model model;
    private View view;
    private Scanner scanner;

    /**
     * Common constructor for creating UtilityController with model and view
     *
     * @param model   - object that we'll be using for connecting with Model entity, actually for setters
     * @param view    - object that we'll be using for connecting with View entity, actually for getting literals for menu
     * @param scanner - Scanner which we open in Controller.class
     */
    public UtilityController(Model model, View view, Scanner scanner) {
        this.model = model;
        this.view = view;
        this.scanner = scanner;
    }

    /**
     * @param regex - regex, which help us check accessibility for this line from Scanner
     * @param nameOfData - type of which we want input
     * @return - result of work with console, actually contains the last line + checking with regex
     */
    public String inputStringValueWithScanner(String nameOfData, String regex) throws UnsupportedEncodingException {
        view.printInputMessage(nameOfData);
        String result;
        while (!(scanner.hasNextLine() &&
                (result = scanner.nextLine()).matches(regex))) {
            view.printWrongInputMessage(nameOfData);
        }
        return result;
    }
}
