package whiteBox;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import cn.edu.hit.exp1.*;
public class ExpressionTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testInput1() {

        // String test = "4*a*c^3*a*5+a^4*12*c*b*12*b+c+1*a";
        String test = "";
        Input exp = new Input(test);
        boolean str = exp.expressionLegal();
        assertEquals(false, str);
        

    }

    @Test
    public void testInput2() {

        // String test = "4*a*c^3*a*5+a^4*12*c*b*12*b+c+1*a";
        String test = "#";
        Input exp = new Input(test);
        boolean str = exp.expressionLegal();
        assertEquals(false, str);
        
    }

    @Test
    public void testInput3() {

        // String test = "4*a*c^3*a*5+a^4*12*c*b*12*b+c+1*a";
        String test = "+";
        Input exp = new Input(test);
        boolean str = exp.expressionLegal();
        assertEquals(false, str);
        

    }

    @Test
    public void testInput4() {

        // String test = "4*a*c^3*a*5+a^4*12*c*b*12*b+c+1*a";
        String test = "A+*";
        Input exp = new Input(test);
        boolean str = exp.expressionLegal();
        assertEquals(false, str);
    }
    @Test
    public void testInput5() {

        // String test = "4*a*c^3*a*5+a^4*12*c*b*12*b+c+1*a";
        String test = "3++";
        Input exp = new Input(test);
        boolean str = exp.expressionLegal();
        assertEquals(false, str);

    }
    @Test
    public void testInput6() {

        // String test = "4*a*c^3*a*5+a^4*12*c*b*12*b+c+1*a";
        String test = "ab";
        Input exp = new Input(test);
        boolean str = exp.expressionLegal();
        assertEquals(false, str);

    }
    @Test
    public void testInput7() {

        // String test = "4*a*c^3*a*5+a^4*12*c*b*12*b+c+1*a";
        String test = "a";
        Input exp = new Input(test);
        boolean str = exp.expressionLegal();
        assertEquals(true, str);
        if (str == true) {
            Expression p = new Expression(exp.getText());
            String expected = "a";
            assertEquals(expected, p.toString());
        }

    }
    @Test
    public void testInput8() {

        // String test = "4*a*c^3*a*5+a^4*12*c*b*12*b+c+1*a";
        String test = "a*12";
        Input exp = new Input(test);
        boolean str = exp.expressionLegal();
        assertEquals(true, str);
        if (str == true) {
            Expression p = new Expression(exp.getText());
            String expected = "12*a";
            assertEquals(expected, p.toString());
        }

    }
    @Test
    public void testInput9() {

        // String test = "4*a*c^3*a*5+a^4*12*c*b*12*b+c+1*a";
        String test = "a^3";
        Input exp = new Input(test);
        boolean str = exp.expressionLegal();
        assertEquals(true, str);
        if (str == true) {
            Expression p = new Expression(exp.getText());
            String expected = "a^3";
            assertEquals(expected, p.toString());
        }
    }
    @Test
    public void testInput10() {

        // String test = "4*a*c^3*a*5+a^4*12*c*b*12*b+c+1*a";
        String test = "a+b";
        Input exp = new Input(test);
        boolean str = exp.expressionLegal();
        assertEquals(true, str);
        if (str == true) {
            Expression p = new Expression(exp.getText());
            String expected = "a+b";
            assertEquals(expected, p.toString());
        }
    }
    @Test
    public void testInput11() {

        // String test = "4*a*c^3*a*5+a^4*12*c*b*12*b+c+1*a";
        String test = "a*2*a*a";
        Input exp = new Input(test);
        boolean str = exp.expressionLegal();
        assertEquals(true, str);
        if (str == true) {
            Expression p = new Expression(exp.getText());
            String expected = "2*a^3";
            assertEquals(expected, p.toString());
        }
    }
    @Test
    public void testInput12() {

        // String test = "4*a*c^3*a*5+a^4*12*c*b*12*b+c+1*a";
        String test = "0*a+b*c";
        Input exp = new Input(test);
        boolean str = exp.expressionLegal();
        assertEquals(true, str);
        if (str == true) {
            Expression p = new Expression(exp.getText());
            String expected = "b*c";
            assertEquals(expected, p.toString());
        }
    }
    @Test
    public void testInput13() {

        // String test = "4*a*c^3*a*5+a^4*12*c*b*12*b+c+1*a";
        String test = "a*0+b*2*0*c";
        Input exp = new Input(test);
        boolean str = exp.expressionLegal();
        assertEquals(true, str);
        if (str == true) {
            Expression p = new Expression(exp.getText());
            String expected = "0";
            assertEquals(expected, p.toString());
        }
    }
    @Test
    public void testInput14() {

        // String test = "4*a*c^3*a*5+a^4*12*c*b*12*b+c+1*a";
        String test = "a*b*1";
        Input exp = new Input(test);
        boolean str = exp.expressionLegal();
        assertEquals(true, str);
        if (str == true) {
            Expression p = new Expression(exp.getText());
            String expected = "a*b";
            assertEquals(expected, p.toString());
        }
    }
    @Test
    public void testInput15() {

        // String test = "4*a*c^3*a*5+a^4*12*c*b*12*b+c+1*a";
        String test = "1*a";
        Input exp = new Input(test);
        boolean str = exp.expressionLegal();
        assertEquals(true, str);
        if (str == true) {
            Expression p = new Expression(exp.getText());
            String expected = "a";
            assertEquals(expected, p.toString());
        }
    }
    @Test
    public void testInput16() {

        // String test = "4*a*c^3*a*5+a^4*12*c*b*12*b+c+1*a";
        String test = "a*4*a^3*b*c*a^2";
        Input exp = new Input(test);
        boolean str = exp.expressionLegal();
        assertEquals(true, str);
        if (str == true) {
            Expression p = new Expression(exp.getText());
            String expected = "4*a^6*b*c";
            assertEquals(expected, p.toString());
        }
    }
}
