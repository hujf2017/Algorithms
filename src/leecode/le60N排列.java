package leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hujf
 * @title: le60N排列
 * @date 2020/9/5 0005下午 5:52
 * @description: TODO
 */
public class le60N排列 {
    public static void main(String args[]){
        System.out.println(getPermutation(3,3));

    }

    public static String getPermutation(int n, int k) {
        String str ="";
        List a = new ArrayList<>();
        for(int i=1;i<n;i++){
            a.add(i);
        }

        int p[] = new int[n+1];
        p[0] = p[1] =1;
        List a2 = new ArrayList<>();
        a2.add(0);
        for(int i=2;i<n;i++){
            p[i] = p[i-1]*i;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<a2.size();j++){

            }
        }


        int sum = 1;
        for(int i=2;i<=n-1;i++){
            sum *=i;
        }
        int s = k%sum;
        int ks2  = k/sum;

        str = str+a.get(ks2+1);

        return str;
    }

}
