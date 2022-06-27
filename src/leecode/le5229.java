package leecode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author hujf
 * @Date 2022/6/27 10:41
 * @Description TODO
 */
public class le5229 {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int max;
        int[] count = new int[nums1.length];
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < nums1.length; i++) {
            count[i] = nums1[i] - nums2[i];
            sum1 += nums1[i];
            sum2 += nums2[i];
        }

        max = Math.max(sum1,sum2);
        //第三种 换子数组  其实就是求子数组阶段最大
        int coun=0;
        int maxs =0;
        for(int i=0;i<count.length;i++){
            coun+=count[i];
            if(coun<0){
                coun=0;
            }
            if(coun>maxs){
                maxs = coun;
            }
        }

        int num1 = sum2+maxs;

        coun=0;
        int min =1;
        for(int i=0;i<count.length;i++){
            coun+=count[i];
            if(coun>0){
                coun=0;
            }
            if(coun<min){
                min = coun;
            }
        }

        int num2 = sum1-min;

        return Math.max(Math.max(num1,num2),max);

    }


    @Test
    public void t() {
        maximumsSplicedArray(new int[]{60,60,60}, new int[]{10,90,10});
    }
}
