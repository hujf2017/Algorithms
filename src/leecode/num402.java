package leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hujf
 * @title: num402
 * @date 2020/11/15 0015上午 9:59
 * @description: TODO
 */
public class num402 {
    boolean isok=false;
    public String removeKdigits(String num, int k) {
        if(num.length()==k){
            return 0+"";
        }
        

        if(k==0||isok==true){
            isok = true;
            return num;
        }
        char [] a = num.toCharArray();
        //找第一个逆序，就可以直接干掉了
        char last = a[0];
        for(int j=1;j<a.length;j++){
            if(last>=a[j]){
                System.out.println(num);
                k--;
                if (k >= 0) {
                    num= removeKdigits(num.replaceFirst(String.valueOf(a[j-1]),""),k);
                }
                break;
            }
            last = a[j];
        }

        return num;
    }


    @Test
    public void t(){
        removeKdigits("10200",2);
    }
}
