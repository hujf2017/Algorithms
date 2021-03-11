package leecode;

import org.junit.Test;

import java.beans.Transient;
import java.util.Deque;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Hujf
 * @title: le227
 * @date 2021/3/1110:21
 * @description: TODO
 */
public class le227 {

    private static char a = '+';
    private static char b = '-';
    private static char c = '*';
    private static char d = '/';

    public int calculate(String s) {
        Queue<String> deque = new ArrayBlockingQueue<String>(500000);
        Queue<String> deque2 = new ArrayBlockingQueue<String>(500000);
        char[] xs = s.toCharArray();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < xs.length; i++) {
            //kong
            if (xs[i] == ' ') {
                continue;
            }
            if (deque2.isEmpty()) {
                if (xs[i] == a || xs[i] == b) {
                    //等于+ /-  把之前的数字放到栈里面 把这个符号放到栈里面
                    deque.add(buf.toString());
                    deque.add(String.valueOf(xs[i]));
                    buf.delete(0, buf.length());
                } else if (xs[i] == c || xs[i] == d) {
                    //等于 * 、/把数字弹出 以及到下一个出现的符号 进行合并
                    deque2.add(buf.toString());
                    deque2.add(String.valueOf(xs[i]));
                    buf.delete(0, buf.length());
                } else {
                    //把两个数字进行合
                    buf.append(xs[i]);
                }
            } else {
                //非空
                if (xs[i] == a || xs[i] == b || xs[i] == c || xs[i] == d) {
                    int num = Integer.valueOf(deque2.poll());
                    String sad = deque2.poll();
                    char fuhao = sad.charAt(0);
                    int numb = Integer.valueOf(buf.toString());
                    int sum;
                    if (fuhao == c) {
                        sum = num * numb;
                    } else {
                        sum = num / numb;
                    }
                    if (xs[i] == c || xs[i] == d) {
                        deque2.add(String.valueOf(sum));
                        deque2.add(String.valueOf(xs[i]));
                    } else {
                        deque.add(String.valueOf(sum));
                        deque.add(String.valueOf(xs[i]));
                    }

                    buf.delete(0, buf.length());
                } else {
                    //把两个数字进行合并；
                    buf.append(xs[i]);
                }
            }
        }
        int sum = Integer.valueOf(buf.toString());
        while (!deque2.isEmpty()) {
            int num2 = Integer.valueOf(deque2.poll());
            char fuhao = deque2.poll().charAt(0);

            if (fuhao == c) {
                sum = num2 * sum;
            } else {
                sum = num2 / sum;
            }
        }
        deque.add(sum + "");
        int k = Integer.parseInt(Objects.requireNonNull(deque.poll()));
        while (!deque.isEmpty()) {
            char fuhao = deque.poll().charAt(0);
            int num1 = Integer.valueOf(deque.poll().toString());
            if (fuhao == a) {
                k += num1;
            } else {
                k -= num1;
            }
        }

        return k;
    }


    @Test
    public void t() {
        System.out.println(calculate(" 2*3*4 "));
    }

}
