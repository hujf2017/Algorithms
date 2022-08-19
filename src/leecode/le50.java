package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/8/17 9:35
 * @Description TODO
 */
public class le50 {

    public double myPow(double x, int n) {
        if (n > 0) {
            return fastM(x, n);
        } else if (n == 0) {
            return 1D;
        } else {
            long xx  =n;
            return fastM( 1 / x, Math.abs(xx));
        }
    }

    private double fastM( double x, long n) {
        double y =x;
        long z =1;
        while(z<n){
            z=z*2;
            y = y*y;
        }
        long k=z-n;
        double s=0;
        if(k!=0){
             s = fastM(x,k);
        }
        return k==0?y:y/s;
    }


    @Test
    public void t() {
        System.out.println(myPow(2.00000, -2147483648));
    }
}
