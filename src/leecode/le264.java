package leecode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Hujf
 * @title: le264
 * @date 2021/4/1110:08
 * @description: TODO
 */
public class le264 {
    int []table = new int [1691];
    public int nthUglyNumber(int n) {
        int p2 =0,p3=0,p5=0;

        int i=0;
        table[i]=1;
        while (i<1690){
            i++;
            int num2 = table[p2]*2;
            int num3 = table[p3]*3;
            int num5 = table[p5]*5;
            int num = Math.min(Math.min(num2,num3),num5);
            if(num==num2){
                p2++;
            }
            if(num==num3){
                p3++;
            }
            if(num==num5){
                p5++;
            }
            table[i] = num;
        }
        return table[n-1];
    }



    @Test
    public void t(){
        nthUglyNumber(10);
    }
}
