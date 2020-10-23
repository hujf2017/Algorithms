package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hujf
 * @title: le728
 * @date 2020/9/5 0005下午 12:18
 * @description: TODO
 */
public class le728 {
    public static void main(String args[]) {
        List a = selfDividingNumbers(1,22);
        System.out.println(a);

    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List a = new ArrayList();
        for(int i=left;i<=right;i++){
            String s = String.valueOf(i);
            int len = s.length();
            boolean isOK = true;
            for(int j=0;j<len;j++){
                int n =s.charAt(j)-48;
                if(n==0||i%n!=0){
                    isOK = false;
                    break;
                }
            }
            if(isOK == true){
                a.add(Integer.valueOf(s));
            }
        }
        return a;
    }
}
