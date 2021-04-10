package 排序;

import org.junit.Test;

/**
 * @author Hujf
 * @title: 希尔排序
 * @date 2021/4/1016:53
 * @description: 进阶版直接插入排序
 */
public class 希尔排序 {

    private int[] a = new int[]{1,34,5,3,65,7,4,3,4,6,7,5,5,4,43,5,7,6,4};

    @Test
    public void method(){
        int step = 1;
        int len = a.length;
        while(step<len/3){
            step = step*3+1;
        }
        for(;step>=1;step/=3){
            //两辆比较
            for(int i=0;i<a.length-step;i+=step){
                for(int j = i+step;j>0;j-=step){
                    if(a[j]<a[j-step]){
                        int tmp = a[j];
                        a[j] = a[j-step];
                        a[j-step] = tmp;
                    }
                }
            }
        }

        for(int num:a){
            System.out.print(num+"\t");
        }
    }
}
