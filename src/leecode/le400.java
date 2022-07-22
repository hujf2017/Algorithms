package leecode;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @Author hujf
 * @Date 2022/7/22 16:57
 * @Description TODO
 */
public class le400 {

    public int findNthDigit(int n) {
        String s = "";
        BigDecimal bigDecimal1 = new BigDecimal(1);
        BigDecimal bigDecimal = new BigDecimal(1);
        while (n > 0) {
            s = bigDecimal.toString();
            n -= s.length();
            bigDecimal = bigDecimal.add(bigDecimal1);
        }
        int num = Integer.valueOf(s.substring(s.length() - 1 + n, s.length() + n));
        return num;
    }

    @Test
    public void t() {
        System.out.println(findNthDigit2(1000000000));
    }


    public int findNthDigit2(int n) {
        int x = 1;
        while (x * 9 * Math.pow(10, x-1) < n) {
            n -= x * 9 * Math.pow(10, x-1);
            x++;
        }

        long s = n / x;
        long x1 = (long) Math.pow(10, x - 1) +s-1;
        int k = (int) (n - x * s);

        if(k==0){
            String sx = String.valueOf(x1);
            return  Integer.valueOf(sx.substring(sx.length()-1));
        }else{
            x1 =x1+1 ;
           String sx = String.valueOf(x1);
           return Integer.valueOf(sx.substring(k-1,k));
        }
    }
}
