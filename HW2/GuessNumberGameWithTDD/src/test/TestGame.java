package test;

import game.Controller;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class TestGame {
    private static Controller controller;

    @BeforeClass
    public static void initController() {
        controller = new Controller();
    }

    @Test
    public void testComparing_1_and_2() {
        Assert.assertEquals("greater", compareNumbersForTest(1,2));
    }

    @Test
    public void testComparing_2_and_1() {
        Assert.assertEquals("lesser", compareNumbersForTest(2,1));
    }

    @Test
    public void testComparing_1_and_1() {
        Assert.assertEquals("equal", compareNumbersForTest(1,1));
    }

    public String compareNumbersForTest(int firstNumber, int secondNumber){
        return controller.compareNumbers(firstNumber, secondNumber);
    }

}
