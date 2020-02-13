package company.view;

/**
 * Entity, which represent view in mvc, actually contains constants and printing method
 */
public class View {
    /**
     * Method, which print message
     *
     * @param message - String, which will be printing
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    public String concatenateStrings(String... messages) {
        StringBuilder result = new StringBuilder();
        for (String message : messages) {
            result.append(message);
        }
        return new String(result);
    }
}
