package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/10/12 15:45
 * @Description TODO
 */
public class le2425 {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int num1 =0;
        int len1 = nums1.length%2;
        int len2 = nums2.length%2;
        for(int i=0;i<nums1.length;i++){
            num1 = num1^(len2*nums1[i]);
        }

        for(int i=0;i<nums2.length;i++){
            num1 = num1^(len1*nums2[i]);
        }
        return num1;
    }


    @Test
    public void t(){
        xorAllNums(new int[]{2,1,3},new int[]{10,2,5,0});
    }
}
