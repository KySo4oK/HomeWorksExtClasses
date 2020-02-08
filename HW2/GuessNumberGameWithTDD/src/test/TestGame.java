package test;

import game.Controller;
import game.Model;
import game.View;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class TestGame {
    private static Controller controller;
    private static Model model;

    @BeforeClass
    public static void initController() {
        controller = new Controller(new Model(), new View());
        model = controller.getModel();
    }

    @Test
    public void testRange() {
        model.setRange(0, 100);
        Assert.assertTrue(((0 == model.getMin()) && (100 == model.getMax())));
    }

    @Ignore
    @Test
    public void testSetRandomNumber() {
        for (int i = 0; i < 10000; i++) {
            model.setRandomNumber();
            if ((model.getOrderValue() > 99) || (model.getOrderValue() < 1)) {
                Assert.fail();
            }
        }
    }

    @Test
    public void testCheckValue() {
        Assert.assertTrue(controller.checkValue(model.getOrderValue()));
    }
}
