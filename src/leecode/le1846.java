package leecode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Hujf
 * @title: le1846
 * @date 2021-07-15 8:49
 * @description: 要计算一个数组中的最大值
 */
public class le1846 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int aim = 0;
        for(int num:arr){
            if(num-aim>1){
                num = aim+1;
            }
            aim = num;
        }
        return aim;
    }

    @Test
    public void t(){
        System.out.println("maximumElementAfterDecrementingAndRearranging(new int[]{2,2,1,2,1}) = " + maximumElementAfterDecrementingAndRearranging(new int[]{100,1,1000}));
    }
}
