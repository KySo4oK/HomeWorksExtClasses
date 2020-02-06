package mvc;

import java.util.Scanner;

/**
 * Created by User on 17.03.2016.
 */
public class Controller {
    // The Regex
    // «nick@mail.com»
    public static final String REGEX_MAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    // «http://www.my-site.com»
    public static final String REGEX_URL = "^((https?|ftp)\\:\\/\\/)?([a-z0-9]{1})((\\.[a-z0-9-])|([a-z0-9-]))*\\.([a-z]{2,6})(\\/?)$";
    // «+38(044)555-55-55»
    public static final String REGEX_PHONE = "^\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$";

    // Constructor
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    // The Work method
    public void processUser() {
        Scanner sc = new Scanner(System.in);

        model.setFirstWord(inputStringValueWithScanner(sc, view.HELLO));
        model.setSecondWord(inputStringValueWithScanner(sc, view.JAVA));

        view.printMessage(model.getFirstWord() + view.SEPARATOR + model.getSecondWord());
    }

    // The Utility methods
    public String inputStringValueWithScanner(Scanner sc, String rightLine) {
        view.printMessage(View.INPUT_STRING_DATA);
        String str = sc.nextLine();
        while (checkLine(str, rightLine)) {
            view.printMessage(View.WRONG_INPUT_STRING_DATA + View.INPUT_STRING_DATA);
            str = sc.nextLine();
        }
        return str;
    }

    public boolean checkLine(String str, String rightLine) {
        if (str.equals(rightLine)) {
            return false;
        }
        return true;
    }
}
