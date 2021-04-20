package 面试;

import java.util.Scanner;

/**
 * @author Hujf
 * @title: Main
 * @date 2021/4/1218:27
 * @description: TODO
 */
public class Main {

    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        String xs[] =  s.split(" ");
//        System.out.println( xs[xs.length-1].length());

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char  []ss= s.toLowerCase().toCharArray();
        char a = scanner.nextLine().toLowerCase().charAt(0);
        int count =0;
        for(char as:ss){
            if(as==a){
                count++;
            }
        }
        System.out.println(count);
    }
}
