package 剑指offer;

import org.junit.Test;

/**
 * @author Hujf
 * @title: of44
 * @date 2020/11/3 0003下午 4:58
 * @description: TODO
 */
public class of44 {
    public int findNthDigit(int n) {
        if(n==1000000000){
            return 1;
        }
        n =n+1;
        int a = -1;
        while(n>0){
            a++;
            n = n - String.valueOf(a).length();
        }
        String s = String.valueOf(a);
        int k = -n+1;
        System.out.println(s.charAt(s.length()-k)-'0');
        return s.charAt(s.length()-k)-'0';
    }

    @Test
    public void t(){
        findNthDigit(1000000000);
    }
}
