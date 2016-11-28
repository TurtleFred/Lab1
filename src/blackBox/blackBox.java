package blackBox;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cn.edu.hit.exp1.Expression;
import cn.edu.hit.exp1.Input;

public class blackBox {
    private Input ipt;
    private Expression p;
    
    @Before
    public void before(){
        p = new Expression("2*a^3+4*b");
    }
    
    @Test
    public void test1(){
        ipt = new Input("!d/d a");
        ipt.derivative(p);
        assertTrue(ipt.derivativeLegal());
    }
    
    @Test
    public void test2(){
        ipt = new Input("!b/b a");
        ipt.derivative(p);
        assertFalse(ipt.derivativeLegal());
    }
    
    @Test
    public void test3(){
        ipt = new Input("!d/d c");
        ipt.derivative(p);
        assertTrue(ipt.derivativeLegal());
    }
    
    @Test
    public void test4(){
        ipt = new Input("!d/d a b");
        ipt.derivative(p);
        assertFalse(ipt.derivativeLegal());
    }
    
}
