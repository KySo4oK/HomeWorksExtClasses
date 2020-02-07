package test;

import game.Controller;
import org.junit.Assert;
import org.junit.Test;

public class TestGame {
    @Test
    public void testComparing_1_and_2(){
        Controller controller = new Controller();
        String result = controller.compareNumbers(1,2);
        Assert.assertEquals("greater", result);
    }

}
