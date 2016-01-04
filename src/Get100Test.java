/**
 * Created by wangxing on 2015/12/20.
 */

/*
 * 在1,2,…,9（保持这个顺序）之间可任意放+或-或都不放使其结果等于100，输出所有可能的放法。
 * 例如：1 + 2 + 3 – 4 + 5 + 6 + 78 + 9 = 100。
*/

import java.util.Stack;
import java.util.Vector;

public class Get100Test {
    static String[] symbol = {"+", "-", ""};
    static String[] num1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    static String[] num2 = {"9", "8", "7", "6", "5", "4", "3", "2", "1"};
    private static Vector<String> strVector; // 存储所有表达式

    /**
     * 穷举出所有的表达式
     *
     * @param prevStr
     * @param length
     */
    public static void hundred(String prevStr, int length) {
        // 加入下一个数字
        if (length <= num1.length) {
            prevStr += num1[length - 1];
        }
        for (int i = 0; i < symbol.length; i++) {
            // 如果还没到第九个数字，加入下一个符号，继续递归
            if (length < num1.length) {
                String nextStr = prevStr + symbol[i];
                hundred(nextStr, length + 1);
            } else {// 如果已经到第九个数字，加入到strVector中
                getStrVector().addElement(prevStr);
                break;
            }
        }
    }

    public static void main(String[] args) {
        if (getStrVector() == null) {
            setStrVector(new Vector<String>());
        } else {
            getStrVector().removeAllElements();
        }
        String prevStr = "";
        hundred(prevStr, 1);
        int count = 0;
        for (int i = 0; i < getStrVector().size(); i++) {
            if (valueFloat(toPostfix((String) getStrVector().elementAt(i))) == 100) {
                // 输出符合条件的表达式
                System.out.println("解" + (count + 1) + ": "
                        + getStrVector().elementAt(i) + "=100");
                count++;
            }
        }
        // 输出符合条件的表达式的个数
        System.out.println("符合条件的等式一共有：" + count + "个。");
    }

    /**
     * 将中缀表达式转为后缀表达式
     *
     * @param expstr
     * @return
     */
    public static String toPostfix(String expstr) {
        Stack<String> stack = new Stack<String>();
        String postfix = "";
        int i = 0;
        while (i < expstr.length()) {
            char ch = expstr.charAt(i);
            switch (ch) {
                case '+':
                case '-':
                    while (!stack.isEmpty()) {
                        postfix += stack.pop();
                    }
                    stack.push(ch + "");
                    i++;
                    break;
                case '*':
                case '/':
                    while (!stack.isEmpty()
                            && (stack.peek().equals("*") || stack.peek()
                            .equals("/"))) {
                        postfix += stack.pop();
                    }
                    stack.push(ch + "");
                    i++;
                    break;
                default:
                    while (ch >= '0' && ch <= '9') {
                        postfix += ch;
                        i++;
                        if (i < expstr.length()) {
                            ch = expstr.charAt(i);
                        } else {
                            ch = '=';
                        }
                    }
                    postfix += " ";
            }
        }
        while (!stack.isEmpty()) {
            postfix += stack.pop();
        }
        return postfix;
    }

    /**
     * 计算后缀表达式的值
     *
     * @param postfix
     * @return
     */
    public static float valueFloat(String postfix) {
        Stack<Float> stack = new Stack<Float>();
        int i = 0;
        float result = 0;
        while (i < postfix.length()) {
            char ch = postfix.charAt(i);
            if (ch >= '0' && ch <= '9') {
                result = 0;
                while (ch != ' ') {
                    result = result * 10 + Integer.parseInt(ch + "");
                    i++;
                    ch = postfix.charAt(i);
                }
                i++;
                stack.push(new Float(result));
            } else {
                float y = stack.pop().floatValue();
                float x = stack.pop().floatValue();
                switch (ch) {
                    case '+':
                        result = x + y;
                        break;
                    case '-':
                        result = x - y;
                        break;
                    case '*':
                        result = x * y;
                        break;
                    case '/':
                        result = x / y;
                        break;
                }
                stack.push(new Float(result));
                i++;
            }
        }
        return stack.pop().floatValue();
    }

    public static Vector<String> getStrVector() {
        return strVector;
    }

    public static void setStrVector(Vector<String> strVector) {
        Get100Test.strVector = strVector;
    }
}
