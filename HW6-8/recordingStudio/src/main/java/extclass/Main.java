package extclass;

import extclass.controller.Controller;
import extclass.model.Model;
import extclass.view.View;

public class Main {
    public static void main(String[] args){
        Controller controller = new Controller(new Model(10), new View());
        controller.processUser();
    }
}
