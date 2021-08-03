package pat.字符串;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Hujf
 * @title: pat5
 * @date 2021-08-03 13:12
 * @description: 给出一个非负整数  求出所有数字和 并用英语转换一下
 */
public class pat5 {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(reader);
        String []s = buf.readLine().split("");
        int sum = 0;
        for(int i=0;i<s.length;i++){
           sum +=Integer.parseInt(s[i]);
        }

        if(sum==0){
            System.out.print(a[0]);
        }

        deal(sum);
    }

    static String []a = {"zero","one","two","three","four","five","six","seven","eight","nine"};
    private static void deal(int sum) {
        List linkedList = new ArrayList();
        int num = 0;
        while(sum>0){
            int k = sum%10;
            linkedList.add(a[k]);
            sum=sum/10;
            num++;
        }
        while(num>1){
            System.out.print(linkedList.get(--num)+" ");
        }
        if(num==1) {
            System.out.print(linkedList.get(--num));
        }
    }
}




//
//
//import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.util.ArrayList;
//        import java.util.List;
//
//public class Main {
//
//    /**
//     * @param args
//     * 2019-12-25下午1:50:28
//     * @throws IOException
//     */
//    static String m[] = { "zero", "one", "two", "three", "four", "five", "six",
//            "seven", "eight", "nine" };
//    public static void main(String[] args) throws IOException {
//        InputStreamReader in = new InputStreamReader(System.in);
//        BufferedReader buf = new BufferedReader(in);
//        char[] str1 = buf.readLine().toCharArray();
//        int a = 0;
//        for(int i=0;i<str1.length;i++){
//            a = a+str1[i]-48;
//        }
//        List <Integer>l = new ArrayList<Integer>();
//        while(a>0){
//            l.add(a%10);
//            a = a/10;
//        }
//        for(int i=l.size()-1;i>0;i--){
//            System.out.print(m[l.get(i)]+" " );
//        }
//        if(l.size()==0){
//            System.out.print("zero");
//        }else{
//            System.out.print(m[l.get(0)]);
//        }
//    }
//
//}
