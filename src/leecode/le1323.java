package leecode;

import java.util.Scanner;

/**
 * @author Hujf
 * @title: le1323
 * @date 2020/9/5 0005上午 10:43
 * @description: TODO
 */
public class le1323 {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            int n = s.nextInt();
            String str = String.valueOf(n);

            String str2 =str.replaceFirst("6","9");
            System.out.println(Integer.valueOf(str2));

        }

    }

}
