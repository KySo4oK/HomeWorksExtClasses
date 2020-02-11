package company;

import company.controller.Controller;
import company.model.Model;
import company.view.View;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new Model(), new View());
        controller.processUser();
    }
}
