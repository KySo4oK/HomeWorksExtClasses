package test;

import game.Controller;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class TestGame {
    private static Controller controller;

    public void initController() {
        controller = new Controller();
    }

    @Test
    public void testComparing_1_and_2() {
        initController();
        String result = controller.compareNumbers(1, 2);
        Assert.assertEquals("greater", result);
    }

    @Test
    public void testComparing_2_and_1() {
        initController();
        String result = controller.compareNumbers(2, 1);
        Assert.assertEquals("lesser", result);
    }

}
