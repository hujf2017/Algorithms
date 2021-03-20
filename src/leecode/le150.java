package leecode;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Hujf
 * @title: le150
 * @date 2021/3/2013:35
 * @description: TODO
 */
public class le150 {
    public int evalRPN(String[] tokens){
        Deque<Integer> stack = new LinkedList<Integer>();
        for(String s:tokens){
            if(isSign(s)){
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (s){
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                        break;
                }
            }else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    private boolean isSign(String s) {
        return s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/");
    }


    @Test
    public void t(){
        evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"});
    }
}
//0,"17","+","5","+"