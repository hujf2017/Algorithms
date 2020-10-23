package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le747数组最大
 * @date 2020/9/27 0027下午 12:39
 * @description: TODO
 */
public class le747数组最大 {
    @Test
    public void test(){
        dominantIndex(new int[]{0, 0, 1, 3});
    }
    public int dominantIndex(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int max = -1;
        int secondMax = -1;
        int index =0;
        int index2 =0;
        for(int k :nums){

            if(k>max){
                secondMax = max;
                max = k;
                index = index2;
            }else if(k>secondMax&&k<=max){
                secondMax = k;
            }
            index2++;
        }
        if(secondMax ==0||max/secondMax>=2){
            return index;
        }else{
            return -1;
        }

    }
}
