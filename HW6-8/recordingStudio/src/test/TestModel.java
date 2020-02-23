package test;

import extclass.model.Model;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TestModel {
    @Test
    public void testLengthOfEmptyCollection(){
        Model model = new Model(0);
        Assert.assertEquals(0,model.getLength());
    }

}
