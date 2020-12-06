package 比赛;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author Hujf
 * @title: le5620连续2禁止
 * @date 2020/12/6 0006上午 11:30
 * @description: TODO
 */
public class le5620连续2禁止 {

    public int concatenatedBinary(int n) {
        BigDecimal k = new BigDecimal(1000000007);
        int kx = 1000000007;
        StringBuffer sbf = new StringBuffer("");
        for(int i=1;i<=n;i++){
            sbf.append(Long.toBinaryString(i));
        }
     //   BigDecimal num = new BigDecimal(0);
        long num =0;
        StringBuffer sad= sbf.reverse();
//        for(int i=0;i<sbf.length();i++){
//            int ks = sad.charAt(i)-48;
//            BigDecimal a = new BigDecimal(2).pow(i);
//            BigDecimal add= a.multiply(new BigDecimal(ks));
//            num =num.add(add);
//        }
//        BigDecimal []nums =num.divideAndRemainder(k);
//        return nums[1].intValue();

        for(int i=0;i<sbf.length();i++){
            int ks = sad.charAt(i)-48;
            long a = (long) Math.pow(2,i);
            if(a<0){
                System.out.println("");
            }
            a=a*ks;
            num =(num%kx+a%kx)%kx;
        }
        int s = (int)num;
        if(s<0){
            System.out.println("");
        }
        return (int)num;
    }
    @Test
    public void t() {
        concatenatedBinary(42);
    }
    }
