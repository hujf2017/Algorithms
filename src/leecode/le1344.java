package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le1344
 * @date 2020/10/19 0019下午 8:37
 * @description: TODO
 */
public class le1344 {
    public double angleClock(int hour, int minutes) {
        int hdu = 30;
        double minDu = (double) minutes/60*360;
        double hourDu = (double) hour/12*360+(double) minutes/60*hdu;
        double a = Math.max(minDu,hourDu);
        double b = Math.min(minDu,hourDu);
        if(a-b>=180){
            return  360-(a-b);
        }else{
            return a-b;
        }
    }
    @Test
    public void t(){
        angleClock(12 ,0);
    }
}
