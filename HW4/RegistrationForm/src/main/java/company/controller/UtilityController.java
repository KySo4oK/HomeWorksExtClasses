package company.controller;

import company.model.Model;
import company.view.View;

import java.util.Scanner;

/**
 * Entity for input value from scanner and set them to Model
 */

public class UtilityController {
    private Model model;
    private View view;

    /**
     * Common constructor for creating UtilityController with model and view
     *
     * @param model - object that we'll be using for connecting with Model entity, actually for setters
     * @param view  - object that we'll be using for connecting with View entity, actually for getting literals for menu
     */
    public UtilityController(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * @param scanner - Scanner which we open in Controller.class
     * @param regex   - regex, which help us check accessibility for this line from Scanner
     * @return - result of work with console, actually contains the last line + checking with regex
     */
    public String inputStringValueWithScanner(Scanner scanner, String regex) {
        getInstruction();
        String result;
        while (!(scanner.hasNextLine() &&
                (result = scanner.nextLine()).matches(regex))) {
            view.printMessage(view.WRONG_INPUT_STRING_DATA);
            getInstruction();
        }
        return result;
    }

    /**
     * Method, which print(make View print) instruction for next input
     */

    private void getInstruction() {
        view.printMessage(view.INPUT_STRING_DATA + getNameOfData());
    }

    /**
     * Method for getting name of data, which will be input
     *
     * @return name of data, which will be input
     */

    private String getNameOfData() {
        if (model.getLastName() == null)
            return view.LAST_NAME;
        return view.NICKNAME;
    }
}
