package company;

import company.controller.Controller;
import company.model.Model;
import company.view.View;

import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Controller controller = new Controller(new Model(), new View());
        controller.processUser();
    }
}
