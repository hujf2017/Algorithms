package 面试;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Hujf
 * @title: 计算机
 * @date 2020/9/26 0026上午 9:48
 * @description: TODO
 */
public class 计算机 {

    @Test
    public void test() {
        String s = "0-21";
        System.out.println(calculate(s));
    }

    public int calculate(String s) {
        char [] a = s.toCharArray();
        Deque dequeF = new LinkedList();
        Deque<Integer> dequeNum = new LinkedList();

        for(int i=0;i<a.length;i++){
            int k;
            int b ;
            switch (a[i]){
                case '+':
                    dequeF.add(a[i]);
                    break;
                case '-':
                    dequeF.add(a[i]);
                    break;
                case '*':
                    k = dequeNum.pollLast();
                    if(a[i+1]==' '){
                        i++;
                    }
                    b = a[i+1]-'0';
                    dequeNum.add(k*b);
                    i++;
                    break;
                case '/':
                    k = dequeNum.pollLast();
                    if(a[i+1]==' '){
                        i++;
                    }
                    b = a[i+1]-'0';
                    dequeNum.add(k/b);
                    i++;
                    break;
                case ' ':
                    break;
                default:
                    dequeNum.add(a[i]-'0');
                    break;
            }
        }
        int sum = dequeNum.pollLast();
        if(dequeNum.size()!=dequeF.size()){
            return Integer.valueOf(s.replaceAll(" ",""));
        }
        while(dequeNum.size()>0){
           int sx =  dequeNum.pollLast();
           char sasd = (char) dequeF.pollLast();
            if (sasd == '+') {
                sum+=sx;
            }else{
                sum-=sx;
            }
        }
        return sum;
    }
}
