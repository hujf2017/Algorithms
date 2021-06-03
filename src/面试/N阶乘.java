package 面试;

import org.junit.Test;

/**
 * @author Hujf
 * @title: N阶乘
 * @date 2021-05-28 15:13
 * @description: TODO
 */
public class N阶乘 {
    //会产生0的情况  4*5 10 100 1000
    public int getZero(int num){
        int count =1;
        int cc=0;
        for(int i=1;i<=num;i++){
            if(i%5==0||i%10==4){
                count*=i;
            }
            while(count%10==0){
                count=count/10;
                cc++;
            }
        }
        return cc;
    }


    @Test
    public void t(){
        System.out.println("getZero(10) = " + getZero(25));
    }


    @Test
    public void t1(){
        long a =1L;
        //long z = 243290200817664*22*25;
        for(long i=1;i<=20;i++){
            a *= i;
        }
        System.out.println(a);
    }
}
