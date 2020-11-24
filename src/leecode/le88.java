package leecode;

import java.util.Arrays;

/**
 * @author Hujf
 * @title: le88
 * @date 2020/11/24 0024下午 4:36
 * @description: TODO
 */
public class le88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0;i<n;i++){
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
