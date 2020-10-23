package leecode;

import java.util.Scanner;

/**
 * @author Hujf
 * @title: le70递归
 * @date 2020/9/5 0005上午 10:28
 * @description: TODO
 */
public class le70递归 {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
            int n = s.nextInt();
            int k = cal2c(n);

            System.out.println(k);
        }
    }

    private static int calc(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return calc(n-1)+calc(n-2);
    }


    private static int cal2c(int n) {
        int a = 1, b = 1;
        for (int i = 2; i <= n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
