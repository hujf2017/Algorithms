package 面试.浩鲸;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hujf
 * @title: 字符串替换
 * @date 2021/4/1214:45
 * @description: TODO
 */
public class 字符串替换 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String a = scan.nextLine();
        String b = scan.nextLine();
        char []as = s.toCharArray();
        char ac =a.charAt(0);
        char bc = b.charAt(0);
        int count=0;
        for(int i=0;i<as.length;i++){
            if(as[i]==ac){
                as[i]=bc;
                count++;
            }
        }
        System.out.println("Result String:"+ Arrays.toString(as));
        System.out.println("A count:"+count);
    }
}
