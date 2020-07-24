package test;


import Junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    /*
     * 初始化方法
     * */
    @Before
    public void init() {

    }

    @After
    public void close() {
 
    }

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        int result = calculator.add(1, 1);
        Assert.assertEquals(3, result);
    }
}



