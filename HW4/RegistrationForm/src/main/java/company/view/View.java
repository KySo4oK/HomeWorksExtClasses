package company.view;

/**
 * Entity, which represent view in mvc, actually contains constants and printing method
 */
public class View {
    /**
     * Constants for printing
     */
    public static final String INPUT_STRING_DATA = "Input your - ";
    public static final String LAST_NAME = "last name";
    public static final String NICKNAME = " nickname";
    public static final String WRONG_INPUT_STRING_DATA = "wrong input data, please try again";

    /**
     * Method, which print message
     * @param message - String, which will be printing
     */
    public void printMessage(String message) {
        System.out.println(message);
    }
}
