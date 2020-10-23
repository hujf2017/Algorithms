package pat;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Hujf
 * @title: num1002
 * @date 2020/8/20 0020上午 9:28
 * @description: 实现a+b，
 * 输入格式：a空格b
 * 输出格式：结果 每三位用 逗号隔开
 */
public class num1001两数相加 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int sum = a+b;
        //1.java方法
        System.out.printf("%,d", sum);
        System.out.println();
        //2.正常算法,字符串
        boolean xiaoyu0 = false;
        if(sum <0){
            xiaoyu0 = true;
        }
        String x = String.valueOf(sum);
//        for(int i=x.length()-3; x.charAt(i) ; i -= 3){
//            System.out.println();
//        }

    }

}
