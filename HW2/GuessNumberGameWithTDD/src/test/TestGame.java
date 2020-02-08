package test;

import game.Controller;
import game.Model;
import game.View;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestGame {
    private static Controller controller;
    @BeforeClass
    public static void initController(){
        controller = new Controller(new Model(), new View());
    }
    @Test
    public void testRange(){
        Model model = controller.getModel();
                model.setRange(0,100);
        Assert.assertTrue(((0 == model.getMin()) && (100 == model.getMax())));
    }
}
