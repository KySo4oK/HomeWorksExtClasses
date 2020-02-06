package Test;

import Calculation.Arithmetics;
import org.junit.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

public class TestArithmetics {
    private static Arithmetics a;

    @BeforeAll
    public static void runT() {
        System.out.println("I`m here");
        a = new Arithmetics();
    }

    @Test
    public void testAdd() {
        double res = a.add(3, 7);
        Assert.assertSame(res, 10.0);
    }

    @Test
    public void testMult() {
        double res = a.mult(3, 7);
        Assert.assertSame(res, 21.0);
    }

    @Test
    public void testDeduct() {
        double res = a.deduct(3, 7);
        Assert.assertSame(res, -4.0);
    }

    @Test
    public void testDiv() {
        double res = a.div(10, 5);
        Assert.assertSame(res, 2.0);
    }
}
