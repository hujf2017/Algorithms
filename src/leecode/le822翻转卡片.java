package leecode;

import java.util.Scanner;

/**
 * @author Hujf
 * @title: le822翻转卡片
 * @date 2020/9/5 0005上午 11:08
 * @description: TODO
 */
public class le822翻转卡片 {
    public static void main(String args[]) {
        int[] fronts ={2,1} ;
        int[] backs ={1,1};
        int i =fronts.length;
        int array[] =  new int[2001];
        int min = Integer.MAX_VALUE;
        for(int j=0;j<i;j++){
            if(fronts[j]==backs[j]) {
                array[fronts[j]] =1;
            }
        }
        for(int j=0;j<i;j++){
            if(fronts[j]!=backs[j]) {
                if (min > fronts[j]&&array[fronts[j]]!=1) {
                    min = fronts[j];
                }
                if (min > backs[j]&&array[backs[j]]!=1) {
                    min = backs[j];
                }
            }
        }
        System.out.println(min);

    }
}
