package common;

import org.junit.Test;

/**
 * @author Hujf
 * @title: Calc
 * @date 2020/11/23 0023下午 7:25
 * @description: TODO
 */
public class Calc {

    @Test
    public void t(){
        double num = Math.pow(0.9,14)*15*0.1;
        double num2 = Math.pow(0.7,14)*15*0.3;

        System.out.println(num+"+"+num2+"="+(num+num2));
        System.out.println(num*0.4);
        System.out.println(num2*0.6);
    }
}
