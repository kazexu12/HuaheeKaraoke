/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Stack;
/**
 *
 * @author ASUS
 */
public class LoginPage {
    public double evaluatePositif(String expr){
        Stack<Double> operandStack = new Stack<>();

        for(int i=0;i<expr.length();i++){
            char token = expr.charAt(i);

            if(Character.isDigit(token)){
                operandStack.push((double)(token-'0'));
            }
            else
            {
                double rightOperand = operandStack.pop();
                double leftOperand = operandStack.pop();
                double result = performOperation(leftOperand,rightOperand,token);
                operandStack.push(result);
            }
        }
        return operandStack.pop();
    }

    private static boolean isOperator (char  ch){
        switch (ch){
            case '+':
            case '-':
            case '/':
            case '*':
                return true;
            default:
                return false;
        }
    }

    private double performOperation(double op1, double op2, char operator){
        double result = 0;

        switch (operator){
            case '+':
                result = op1 + op2;
                break;
            case '-':
                result = op1 - op2;
                break;
            case '/':
                result = op1 / op2;
                break;
            case '*':
                result = op1 * op2;
                break;
        }

        return result;
    }
}
