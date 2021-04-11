package leecode;

import org.junit.Test;

import java.util.*;

/**
 * @author Hujf
 * @title: le264
 * @date 2021/4/1110:08
 * @description: TODO
 */
public class le264 {
    int []table = new int [1691];

    //方法1  动态规划+三指针
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


    //方法二  小顶堆
    public int nthUglyNumber2(int n) {
        if(n==1){
            return 1;
        }
        List <Long>list = new ArrayList<>();
        HashSet<Long> set = new HashSet();
        list.add(1L);
        list.add(2L);
        set.add(1L);
        set.add(2L);
        long num=1;
        for(int i=0;i<n;i++) {
            min_heap(list,list.size()-1);
            num = list.get(0);
            list.remove(0);
            if(set.add(num*2)){
                list.add(num*2);
            }
            if(set.add(num*3)){
                list.add(num*3);
            }
            if(set.add(num*5)){
                list.add(num*5);
            }
        }
        return (int) num;
    }

    private void min_heap(List <Long>list, int i) {
        int child ;
        for(int local=(i-1)/2;local>=0;local--){
            child = local*2+1;
            if(local==8){
                System.out.print(112);
            }
            if(child<i&&list.get(child)>list.get(child+1)){
                child++;
            }

            if(list.get(child)<list.get(local)){
                long num = list.get(local);
                list.set(local,list.get(child));
                list.set(child,num);
            }
        }

    }


    @Test
    public void t(){
        nthUglyNumber2(1407);
    }
}
