package Fengkuang;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Etherstrings
 * @create 2023-04-23 10:17 Fengkuang - the name of the target package where the new class or interface will be created.  Test - the name of the current project.  null.java - the name of the PHP file that will be created.  num3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/4/23 - the current system date.  10:17 - the current system time.  2023 - the current year.  04 - the current month.  23 - the current day of the month.  10 - the current hour.  17 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class num3 {
    public static void main(String[] args) {
        num3 n=new num3();
        System.out.println(n.compute("1.5+3*4/2"));
    }
    public double compute(String data) {
        // 将输入的表达式转换为后缀表达式
        String[] tokens = data.split("(?<=[-+*/])|(?=[-+*/])");
        Stack<String> opStack = new Stack<>();
        Queue<String> postfixQueue = new LinkedList<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                while (!opStack.isEmpty() && hasHigherPrecedence(opStack.peek(), token)) {
                    postfixQueue.offer(opStack.pop());
                }
                opStack.push(token);
            } else {
                postfixQueue.offer(token);
            }
        }

        while (!opStack.isEmpty()) {
            postfixQueue.offer(opStack.pop());
        }

        // 计算后缀表达式的值
        Stack<Double> valueStack = new Stack<>();
        for (String token : postfixQueue) {
            if (isOperator(token)) {
                double rightOperand = valueStack.pop();
                double leftOperand = valueStack.pop();
                double result = applyOperator(leftOperand, rightOperand, token);
                valueStack.push(result);
            } else {
                valueStack.push(Double.parseDouble(token));
            }
        }

        return valueStack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private boolean hasHigherPrecedence(String op1, String op2) {
        return (op1.equals("*") || op1.equals("/")) && (op2.equals("+") || op2.equals("-"));
    }

    private double applyOperator(double leftOperand, double rightOperand, String operator) {
        switch (operator) {
            case "+":
                return leftOperand + rightOperand;
            case "-":
                return leftOperand - rightOperand;
            case "*":
                return leftOperand * rightOperand;
            case "/":
                if (rightOperand == 0) {
                    throw new ArithmeticException("Divide by zero");
                }
                return leftOperand / rightOperand;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }




}
