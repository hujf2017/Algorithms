package leecode;

/**
 * @author Hujf
 * @title: le1035
 * @date 2021-05-21 15:39
 * @description: TODO
 * 1 2 3  1 2 3 4
 * 2 3 1  4 2 1 2
 */
public class le1035 {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int len1 =0;
        int len2 =0;

        int count =0;
        for(int i=0;i<nums1.length;i++){
            if(nums1[len1]==nums2[len2]){
                len1++;
                len2++;
                count++;
            }
        }

        return count;

    }
}
