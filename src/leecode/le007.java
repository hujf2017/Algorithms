package leecode;

import java.util.Scanner;

/**
 * @author Hujf
 * @title: le007
 * @date 2020/9/5 0005下午 4:25
 * @description: TODO
 */
public class le007 {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int max = (int) Math.pow(2,32);
        int min = -max+1;
        System.out.println(max);
        System.out.println(min);
        while(scan.hasNext()){
            System.out.println(reverse(scan.nextInt()));
        }
    }

    public  static int reverse(int x) {
        int max = (int) Math.pow(2,32);
        int min = -max+1;

        if(x==0||x>max||x<min){
            return 0;
        }
        boolean isLowZero = false;
        if(x<0){
            x=-x;
            isLowZero = true;
        }
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(x));
        StringBuilder stringBuilder2 = stringBuilder.reverse();
        String s = stringBuilder2.toString().replaceAll("^(0+)","");

        if(Long.valueOf(s)>max||Long.valueOf(s)<min){
            return  0;
        }
        if(isLowZero ){
            return -Integer.valueOf(s);
        }
        return  Integer.valueOf(s);
    }
}
