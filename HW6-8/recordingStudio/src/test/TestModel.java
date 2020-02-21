package test;

public class TestModel {
    @Test
    public void testLengthOfEmptyCollection(){
        Model model = new Model(0);
        Assert.assertEqual(0,model.getLength())
    }

}
