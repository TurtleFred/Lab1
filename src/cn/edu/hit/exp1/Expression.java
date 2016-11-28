package cn.edu.hit.exp1;
 
import java.util.ArrayList;

/**
 * @author CP-D WeiSiDa
 *
 */
public class Expression {
/**
 * public Object 单项式数组;
 */
private ArrayList<SingleTerm> polynomial = new ArrayList<>();

/**
 *public void 代值(char 字母，int 值)
 * @param varName varName
 * @param value value
 */
public final void simplify(final char varName, final int value) {

    for (int i = 0; i < polynomial.size(); i++) {
        polynomial.get(i).simplify(varName, value);
    }
    }


/**
 * public void 求导(char 字母)
 * @param varName varName
 */
public final void derivative(final char varName) {
    for (int j = 0; j < polynomial.size(); j++) {
        polynomial.get(j).derivative(varName);
    }
    }

/**
 * public String 字符串输出()
 */
@Override
    public final String toString() {
    String s = "";
    for (int i = 0; i < polynomial.size(); i++) {
        if (!polynomial.get(i).toString().startsWith("0")) {
        s += polynomial.get(i).toString();
        s += "+";
        }
    }
    if (s.length() == 0) {
        return "0";
    }
    return s.substring(0, s.length() - 1);
    }

/**
 * public 构造对象(String 字符串)
 * @param polynomialStr polynomialStr
 */
public Expression(final String polynomialStr) {
    final String[] product = polynomialStr.split("\\+");
    for (int i = 0; i < product.length; i++) {
        polynomial.add(new SingleTerm(product[i]));
    }
    System.out.println(this);
    }

}
